import java.util.*;
import java.util.concurrent.TimeUnit;

public class SentenceSentiment {
	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Hi! My name's AL, a chatbot designed to talk with you about your feelings. How can I help you today? Please feel free to share any emotions you want with me.");
		
		while (true) {
			String text = scan.nextLine();
			nlpPipeline.init();
			nlpPipeline.estimatingSentiment(text);
			TimeUnit.SECONDS.sleep(5);
			System.out.println("Is there anything else you want to talk about?(y/n). Regardless, know that you are loved!");
			String phrase = scan.nextLine();
			if (phrase.equalsIgnoreCase("n")) {
				System.out.println("If you ever need assistance, you can always return back to chatbot or speak to a trusted individual.");
				System.out.println("Please call 988 or visit https://988lifeline.org/ for additional help.");
				System.out.println("Exiting the program...");
				break;
			} else {
				System.out.println("What else is on your mind?");
			}
		}

	}

}
