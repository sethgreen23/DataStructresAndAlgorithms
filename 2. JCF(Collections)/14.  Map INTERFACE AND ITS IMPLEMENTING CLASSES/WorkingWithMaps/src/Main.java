import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		EnumMap<EuCode,Country> nations = new EnumMap<EuCode,Country>(EuCode.class);
		nations.put(EuCode.FR, new Country("France","French",643801,66.99,40.4));
		nations.put(EuCode.GER, new Country("Germany","German",357386,83.02,46.8));
		nations.put(EuCode.POL, new Country("Poland","Polish",312679,37.97,42.2));
		System.out.printf("Size: %s%n", nations.size());
		System.out.printf("KeySet: %s%n", nations.keySet());
		Collection<Country> countries =nations.values();
		for(Iterator<Country> iterator=countries.iterator();iterator.hasNext();) {
			System.out.println(iterator.next());
		}
		//using entrySet
		System.out.println("iterate throw the map using entryset");
		for(Map.Entry<EuCode, Country> e: nations.entrySet()) {
			System.out.print("Key: "+e.getKey());
			System.out.println(" / Value: "+e.getValue());
		}
	}	
}
enum EuCode{
	FR,GER,IT,SP,POL,HU,CRO,GREE,CEC,POR;
}
class Country{
	
	private String name;
	private String language;
	private int area;
	private double population;
	private double age;
	
	public Country(String name, String language, int area, double population, double age) {
		this.name = name;
		this.language = language;
		this.area = area;
		this.population = population;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Country [name=" + name + ", language=" + language + ", area=" + area + ", population=" + population
				+ ", age=" + age + "]";
	}
	
}

//output
/*
	Size: 3
	KeySet: [FR, GER, POL]
	Country [name=France, language=French, area=643801, population=66.99, age=40.4]
	Country [name=Germany, language=German, area=357386, population=83.02, age=46.8]
	Country [name=Poland, language=Polish, area=312679, population=37.97, age=42.2]
	iterate throw the map using entryset
	Key: FR / Value: Country [name=France, language=French, area=643801, population=66.99, age=40.4]
	Key: GER / Value: Country [name=Germany, language=German, area=357386, population=83.02, age=46.8]
	Key: POL / Value: Country [name=Poland, language=Polish, area=312679, population=37.97, age=42.2]
 */

/*
	A map (also called a dictionary or look-up table) is a collection whose elements are key-value
	pairs. A key is a unique element that acts as an identifier for its value, which is an element that
	typically holds several components of data.
	
	The information shown in Table 4.3 provides a good example. If these data were stored in a map
	data structure, then each row would be stored in a separate keyvalue pair. The keys would be the
	strings in the ISO column. The value for each key would be the rest of the data for the country that
	is uniquely identified by that key.These data could be the fields of a
	Country object, using the Country class defined in Example 4.14.The Map interface is defined like this:
	public interface Map<K,V> .Its type parameters are the key type K and the value type V. The type Map<String,Country>
	could be used for the records in Table 4.3, using the String class for K and a Country class for
	V. (See page 74.)
	The Map interface is shown in Figure 4.11 on page 94. It specifies 14 methods. Note that this
	interface does not extend the Collection interface. (See Figure 4.1 on page 70.) Sets, lists, and
	queues are collections of individual elements, which are not key-value pairs.
	The two subinterfaces and five implementing classes of the Map interface are analogous to the
	corresponding subinterfaces and implementing classes of the Set interface. Like the
	AbstractSet class, the AbstractMap class implements only those methods that are either
	independent of the underlying data structure or can be implemented using the other methods.
	Like the EnumSet, HashSet, LinkedHashSet, and TreeSet classes, the EnumMap, HashMap,
	LinkedHashMap, and TreeMap implement the abstract methods.
	The EnumMap class is defined like this:
	public class EnumMap<K extends Enum<K>,V> extends AbstractMap<K,V>
	The expression K extends Enum<K> means that only enum types can be used for the key type K.
 */