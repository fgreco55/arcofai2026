import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiChatModelName;
import dev.langchain4j.service.AiServices;

import java.util.stream.IntStream;

public class FlightInfo {

    interface FlightAssistant {
        String flightInfo(String userMessage);
    }

    public static void main(String[] args) {
        ChatModel model = OpenAiChatModel.builder()
                .apiKey(System.getenv("OPENAI_API_KEY"))
                .modelName(OpenAiChatModelName.GPT_4_O)
                .strictTools(true)
                //.logRequests(true)
                //.logResponses(true)
                .build();

        ChatMemory cm = MessageWindowChatMemory.withMaxMessages(10);
        cm.add(SystemMessage.from("""
            You are a helpful, and informative flight agent.
            Only use the methods I have described.
            Restrict your responses to flight information.
            """));  // just for illustrative purposes

        FlightAssistant myAssistant = AiServices.builder(FlightAssistant.class)
                .chatModel(model)
                .tools(new FlightInfoTools())
                .chatMemory(cm)         // An effective system message that controls/constrains the method choices is critical.
                .build();

        /*
         Run it several times and notice the differences...
         */
        for (int i = 0; i < 3; i++) {
            runTools(myAssistant);
            System.out.println("=====================================");
        }
    }

    private static void runTools(FlightAssistant myAssistant) {
        String response;

        response = myAssistant.flightInfo("I need the status of Flight UA1011");
        System.out.println(response);

        response = myAssistant.flightInfo("What type of aircraft is it?");
        System.out.println(response);

        response = myAssistant.flightInfo("What was its cost");
        System.out.println(response);

        response = myAssistant.flightInfo("How can I make a pizza?");
        System.out.println(response);
    }
}
