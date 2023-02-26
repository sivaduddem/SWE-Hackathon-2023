import java.util.Properties;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import java.util.*; 

public class nlpPipeline {
	static StanfordCoreNLP pipeline;

	public static void init() {
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, parse, sentiment");
		pipeline = new StanfordCoreNLP(props);
	}

	public static void estimatingSentiment(String text) {
		text.toLowerCase(); 
		Random rand = new Random(); 
		String neg [] = {"I'm sorry you're feeling this way. Please know that you are not alone, and there is always hope for a better tomorrow.", "It's important to take care of yourself during this time. Have you tried getting enough sleep, eating well, and exercising?","Remember that your feelings are valid and it's okay to feel sad. Don't be too hard on yourself.", "It's okay to reach out for help. Have you considered talking to a therapist or counselor?", "Remember that your feelings are valid and important. It's okay to acknowledge and accept them.", "It's important to take care of yourself, even when you're feeling sad. Make sure you're getting enough rest and nourishing your body.", "Remember that sadness is a normal part of the human experience. It's okay to feel this way.", "Sometimes just talking about your feelings can be helpful. I'm here to listen if you need someone to talk to.", "Remember that things will get better with time. This feeling won't last forever.", "It's okay to take a break if you need to. Sometimes rest and relaxation can help you feel better.", "Have you tried doing something kind for someone else? It can help boost your mood and make you feel good about yourself.", "Remember that it's okay to feel vulnerable. It takes strength to acknowledge your emotions and work through them.", "It's important to remember that you're not alone in your sadness. So many people have gone through what you're going through and come out the other side.", "Have you tried getting outside and spending time in nature? It can be a great way to boost your mood and lift your spirits.", "Remember that you're loved and valued. Don't forget that."};
		String pos [] = {"Thank you for sharing such a positive statement!", "I appreciate your positive outlook and attitude.", "Your positivity is inspiring!","Your kind words made my day, thank you!","It's wonderful to hear such a positive statement.","Your positive energy is infectious!","I'm grateful for your positive perspective.","Thank you for reminding me to focus on the good things in life.","Your optimism is truly uplifting.","Your positivity is a breath of fresh air.","It's great to see you radiating such positivity!","Thank you for spreading positivity and kindness.","Your positive statement made me smile.","Your positivity is a powerful force.","I appreciate your positive words more than you know.","Your positive attitude is contagious and much appreciated.", "Thank you for reminding me to stay positive and optimistic.","Your positive statement is a ray of sunshine on a cloudy day.","Your positive energy and enthusiasm are truly infectious.","Your positive statement made my heart happy."};
		String compliment [] = {"You have such a warm and welcoming personality.", "Your positive attitude is contagious and inspiring.","You are a great listener and always make people feel heard.","Your creativity and artistic talent are impressive.","You have a great sense of humor and always know how to make people laugh.", "You are an incredibly kind and compassionate person.", "Your hard work and dedication are truly admirable.","You have a unique and captivating perspective on the world.","You are an excellent communicator and always express yourself well.","Your intelligence and quick thinking are impressive.","You have a great sense of style and always look put-together.","You are a natural leader and inspire others with your actions.","Your generosity and willingness to help others is truly remarkable.","You have a beautiful smile that lights up any room.","Your determination and resilience are admirable.", "You are talented and skilled.", "You have a contagious zest for life that inspires others.", "Your patience and understanding are always appreciated.", "You have a calming presence that puts others at ease.","You are an amazing friend who always goes above and beyond."};
		int sentimentInt = 0;
		String sentimentName;
		Annotation annotation = pipeline.process(text);
		for (CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
			Tree tree = sentence.get(SentimentAnnotatedTree.class);
			 sentimentInt = RNNCoreAnnotations.getPredictedClass(tree);
			 sentimentName = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
			System.out.println(sentimentName + "\t" + sentimentInt + "\t" + sentence);
		}
		if (sentimentInt <= 1) {
			int value = (int)(Math.random()* 15);  
			System.out.println(neg[value]);
		}
		if (sentimentInt == 2) {
			int value = (int)(Math.random()*20);
			System.out.println(compliment[value]);
		}

		if (sentimentInt >= 3 ) {
			int value = (int)(Math.random()* 20);
			System.out.println(pos[value]);
		}



	}
}