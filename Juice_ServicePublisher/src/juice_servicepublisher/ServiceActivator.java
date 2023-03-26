package juice_servicepublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

	ServiceRegistration publishServiceRegistration;

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("JuicePublisher Start");
		juicePublisher publisherService = new JuicePublisherImpl();
		publishServiceRegistration = bundleContext.registerService(juicePublisher.class.getName(), publisherService, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		System.out.println("JuicePublisher Stop");
		publishServiceRegistration.unregister();
		
		
	}

}
