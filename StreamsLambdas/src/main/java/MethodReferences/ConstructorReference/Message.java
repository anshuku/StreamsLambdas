package MethodReferences.ConstructorReference;

interface Messageable {
	Message getMessage(String msg);
}

public class Message implements Messageable {

	Message(String msg) {
		System.out.println(msg);
	}

	@Override
	public Message getMessage(String msg) {
		return new Message(msg + " there!");
	}

	public Message getMyMessage(String msg) {
		return new Message(msg + " there! How are you?");
	}

	public static void main(String[] args) {

		Messageable message = Message::new;
		message.getMessage("Hello!");

		Messageable messageable = new Message("Hi");

		Message m = messageable.getMessage("Hello");

		// can't call this since interface doesn't have it.
		// messageable.getMyMessage("Hello");

		Message messageObj = new Message("Hey");

		Messageable messageableObj = messageObj::getMyMessage;
		Message m1 = messageableObj.getMessage("Heyy");

	}

}
