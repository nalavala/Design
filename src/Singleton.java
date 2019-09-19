import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Singleton {

	public static void main(String args[]) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException,
			IOException, ClassNotFoundException, CloneNotSupportedException {

		
		Runnable task = () -> {
			Registry registry = Registry.getInstance();
			System.out.println(registry.hashCode());
		};

		Thread one = new Thread(task);
		Thread three = new Thread(task);
		Thread two = new Thread(task);
		Thread four = new Thread(task);
		Thread five = new Thread(task);
		Thread six = new Thread(task);

		one.start();
		two.start();
		three.start();
		four.start();
		five.start();
		six.start();
		
		
		/*Registry registry = Registry.getInstance();
		System.out.println(registry.hashCode());
		*/
		
		// Breaking of singleton pattern using reflection
		try {
			Class<Registry> registryClass = (Class<Registry>) Class.forName("Registry");
			Constructor<Registry> privateConstructor = registryClass.getDeclaredConstructor(null);
			privateConstructor.setAccessible(true);
			Registry newInstance = privateConstructor.newInstance();
			System.out.println(privateConstructor);
			System.out.println(newInstance.hashCode());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// Breaking of singleton pattern using serialization
		Registry registry = Registry.getInstance();
        ObjectOutput out 
            = new ObjectOutputStream(new FileOutputStream("file.text")); 
        out.writeObject(registry); 
        out.close(); 
  
        
        ObjectInput in  
            = new ObjectInputStream(new FileInputStream("file.text")); 
          
        Registry registry2 = (Registry) in.readObject(); 
        in.close(); 
  
        System.out.println("instance1 hashCode:- "
                                             + registry.hashCode()); 
        System.out.println("instance2 hashCode:- " 
                                             + registry2.hashCode()); 
        
        // Breaking of singleton using Clone
        /*Registry registry1 = Registry.getInstance();
        Registry registryClone = (Registry) registry1.clone();
        System.out.println(registryClone.hashCode());*/
		
		
        /* Ways to prevent breaking */
        // 1. Throw exception of unsportted clone for clone issue
        
        // 2. serilizable issue
        // by overriding readResolve method to prevent serilizable issue
		/* The readResolve method is called when ObjectInputStream has read an
		 object from the stream and is preparing to return it to the caller*/
        
        // Using enums to avoid reflection issue 

	}

}

// final keyword restricts from being extended
final class Registry implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Lazy initialization of resources intensive operation
	private static Registry registry = null;

	// Other classes can't use new operator to create instance directly
	private Registry() {

	}

	public void addEntry() {

	}

	public void removeEntry() {

	}

	// Global way to access global object of registry
	public static Registry getInstance() {

		// double check thread safe code
		if (registry == null) {
			// class level lock to prevent getting execute this code
			synchronized (Registry.class) {
				if (registry == null) {
					registry = new Registry();
				}
			}
		}

		return registry;
	}
	
	// implement readResolve method 
    protected Object readResolve() 
    { 
        return registry; 
    } 
	
	@Override
	  protected Object clone() throws CloneNotSupportedException  
	  { 
	    return super.clone(); 
	  } 

}
