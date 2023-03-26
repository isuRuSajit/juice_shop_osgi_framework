package juice_servicesubscriber;
import java.util.Scanner;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import juice_servicepublisher.Juice;
import juice_servicepublisher.juicePublisher;

public class ServiceActivator implements BundleActivator {

	ServiceReference serviceReference,serviceReference2,serviceReference3;
	Scanner qtsc = new Scanner(System.in);
	public void start(BundleContext context) throws Exception {


		serviceReference = context.getServiceReference(juicePublisher.class.getName());
		juicePublisher juicePublisher = (juicePublisher) context.getService(serviceReference);
		String qt = "N";
		
		while("N".equalsIgnoreCase(qt)) {
			Juice juice = juicePublisher.menu();
			
			if("Y".equalsIgnoreCase(juice.getBuyOrNo())) {
				
				
			}
			
			System.out.println("Do you want to quit ? (Y/N)");
			qt =  qtsc.next().toString();
			if(qt.equalsIgnoreCase("Y")) {
				System.out.println("thank you and come agian!");
				break;
			}		
		
		}

	

	}

	public void stop(BundleContext context) throws Exception {

		System.out.println("Stop Juice Subscriber Service, Good Byee!");
		context.ungetService(serviceReference);
	}

}
