/*
 * Copyright (c) 2017. AxonIQ
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package axoniqhack.display;

import io.axoniq.eventstore.client.EventStoreConfiguration;
import io.axoniq.eventstore.client.axon.AxonIQEventStore;
import org.axonframework.commandhandling.model.Repository;
import org.axonframework.common.caching.Cache;
import org.axonframework.common.caching.NoCache;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.config.EventHandlingConfiguration;
import org.axonframework.eventsourcing.CachingEventSourcingRepository;
import org.axonframework.eventsourcing.EventCountSnapshotTriggerDefinition;
import org.axonframework.eventsourcing.GenericAggregateFactory;
import org.axonframework.eventsourcing.SnapshotTriggerDefinition;
import org.axonframework.eventsourcing.Snapshotter;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.annotation.ParameterResolverFactory;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.json.JacksonSerializer;
import org.axonframework.spring.eventsourcing.SpringAggregateSnapshotter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author Zoltan Altfatter
 */
@Configuration
public class AxoniqConfiguration {

    @Autowired
    public void config(EventHandlingConfiguration eventHandlingConfiguration) {
        eventHandlingConfiguration.registerTrackingProcessor("MyHandlers");
    }

    @Bean(name = "eventBus")
    public EventStore eventStore(EventStoreConfiguration eventStoreConfiguration, Serializer serializer) {
        return new AxonIQEventStore(eventStoreConfiguration, serializer);
    }

    @Bean
    public EventStoreConfiguration eventStoreConfiguration() {
        return new EventStoreConfiguration();
    }

    @Bean
    public SpringAggregateSnapshotter snapshotter(ParameterResolverFactory parameterResolverFactory, EventStore eventStore, TransactionManager transactionManager) {
        Executor executor = Executors.newSingleThreadExecutor(new CustomizableThreadFactory("SNAPSHOTTER")); //Or any other executor of course
        return new SpringAggregateSnapshotter(eventStore, parameterResolverFactory, executor, transactionManager);
    }

    @Bean
    public SnapshotTriggerDefinition snapshotTriggerDefinition(Snapshotter snapshotter) throws Exception {
        return new EventCountSnapshotTriggerDefinition(snapshotter, 3);
    }

    @Bean
    public Cache cache(){
        return NoCache.INSTANCE;
    }

    @Bean
    public Serializer serializer() {
        return new JacksonSerializer();
    }

}
