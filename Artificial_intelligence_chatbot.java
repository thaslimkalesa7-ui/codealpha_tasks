import java.util.Scanner;

public class Artificial_intelligence_chatbot{
    public static String getResponse(String input) {
        input = input.toLowerCase();
        input = input.replaceAll("[^a-z0-9 ]", "");
        if (input.contains("hello") || input.contains("hi")) {
            return "Hello! How can I help you?";
        }

        else if (input.contains("your name") || input.contains("name")) {
            return "I am Java Chatbot.";
        }

        else if (input.contains("how are you")) {
            return "I am fine! Thank you for asking.";
        }

        else if (input.contains("java")) {
            return "Java is an object-oriented programming language.";
        }

        else if (input.contains("ai") || input.contains("artificial intelligence")) {
            return "AI means Artificial Intelligence. It makes machines smart.";
        }

        else if (input.contains("nlp")) {
            return "NLP helps computers understand human language.";
        }

        else if (input.contains("help")) {
            return "I can answer questions about Java, AI and NLP.";
        }

        else if (input.contains("thank")) {
            return "You are welcome!";
        }

        else if (input.contains("bye") || input.contains("exit")) {
            return "Goodbye! Have a nice day.";
        }

        else {
            return "Sorry, I don't understand. Please ask another question.";
        }
    }
public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("     AI CHATBOT SYSTEM");
        System.out.println("================================");

        System.out.println("Chatbot: Hello! Welcome to AI Chatbot.");
        System.out.println("Chatbot: Type 'bye' to exit.");

        while (true) {

            System.out.print("\nYou: ");
            String userInput = sc.nextLine();

            String response = getResponse(userInput);

            System.out.println("Chatbot: " + response);

            if (userInput.toLowerCase().contains("bye") ||
                userInput.toLowerCase().contains("exit")) {
                break;
            }
        }

        sc.close();
    }
}