#JavaOne2026

# "Introduction to GenAI for Busy Java Developers" @ Arc of AI 2026.
## Example Code

Small subset of code from my LinkedIn Learning courses and my Pearson/OReilly courses.

- HelloWorldGoogle.java - simple
  demonstration of using a LangChain4j ChatModel to access Google Gemini
- ChatService.java - Simple chatbot with and without conversational memory
  Try these prompts "My name is Frank and I enjoy music", then ask the LLM what your name is and what you enjoy.
- PromptTechniques.java - Demonstration of a structured prompt that guides an LLM.
- MyService.java - Simple demonstration of a LangChain4j AiService
- GetEmbedding.java - Example of using an embedding service to retrieve an embedding
  vector for a given string.
- FlightInfo/FlightInfoTools - Example of using Tools with an LLM
- TravelPlannerApp/TravelTools - Example of a simple Agent

These programs need API keys to run.
Visit these sites to register and get an API Key:

- [Google](aistudio.google.com)
- [Anthropic](console.anthropic.com)
- [Mistral](https://docs.mistral.ai/getting-started/quickstart)
- [OpenAI](platform.openai.com)

And in your IDE or terminal just add the specific key to your shell (or environment variables):
- GOOGLE_API_KEY=[*put your key here*]
- MISTRAL_API_KEY=[*put your key here*]
- ANTHROPIC_API_KEY=[*put your key here*]`
