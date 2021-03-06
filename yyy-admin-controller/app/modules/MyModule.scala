package modules

import java.time.Clock

import com.google.inject.AbstractModule
import play.api.libs.concurrent.AkkaGuiceSupport
import services.{AtomicCounter, Counter}
import utils.{DatabaseProvider, DatabaseProviderImpl}

/**
  * This class is a Guice module that tells Guice how to bind several
  * different types. This Guice module is created when the Play
  * application starts.
  *
  * Play will automatically use any class called `Module` that is in
  * the root package. You can create modules in other locations by
  * adding `play.modules.enabled` settings to the `application.conf`
  * configuration file.
  */
class MyModule extends AbstractModule with AkkaGuiceSupport{

    override def configure() = {
        // Use the system clock as the default implementation of Clock
        bind(classOf[Clock]).toInstance(Clock.systemDefaultZone)
        // Ask Guice to create an instance of ApplicationTimer when the
        // application starts.
        // bind(classOf[ApplicationTimer]).asEagerSingleton()
        // Set AtomicCounter as the implementation for Counter.
        bind(classOf[Counter]).to(classOf[AtomicCounter])
        bind(classOf[DatabaseProvider]).to(classOf[DatabaseProviderImpl])
        /*implicit val system = ActorSystem("httpTestSystem")
        implicit val materializer = ActorMaterializer()
        implicit val wsClient: WSClient = AhcWSClient()
        binder.bind(classOf[WSClient]).toInstance(wsClient)*/
    }

}
