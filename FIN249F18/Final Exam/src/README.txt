Notice how in smapleOutput.txt all existing objects are notified at the start of the program, and are notified again after an integer multiple of its wakeUpTime.
More objects are also created along the way, with a 10% chance at each tick.
This explains why you may notice more objects being notified the higher the tick count is.
The program halts after 74 ticks because there's a 1% chance of it stopping instead of adding any objects.
I use an abstract class Notifiable to tell which objects get notifications.
All notifiable objects shall extend Notifiable and implement the abstract method doAlarm.
I also keep track of all the registered objects in an ArrayList with type parameter Notifiable.
This takes advantage of polymorphism to allow us to add any class that implements Notifiable to the list, since any object that extends Notifiable, is an instance of Notifiable.
I could've perhaps created Notifiable as an Interface, but decided against it due to me being more comfortable working with abstract classes, and time constraints.
Using Java for this program has a strong advantage over a language that's not object oriented because, we can use all of these features to make it work smoothly and flexibly.
Keep in mind, we can create a number of extra classes ie. Office, Cafe, or anything else that may need notifications very easily by just implementing the doAlarm method.