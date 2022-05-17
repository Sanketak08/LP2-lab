import nltk
from nltk.chat.util import Chat, reflections
 
reflections = {
    "i am": "you are",
    "i was": "you were",
    "i": "you",
    "i'm": "you are",
    "i'd": "you would",
    "i've": "you have",
    "i'll": "you will",
    "my": "your",
    "you are": "I am",
    "you were": "I was",
    "you've": "I have",
    "you'll": "I will",
    "your": "my",
    "yours": "mine",
    "you": "me",
    "me": "you"
}
 
pairs = [
    [
        r"Where is your store?",
        ["It is at Trimurthi chowk, in front of PICT college", ]
    ],
    [
        r"hi|hey|hello",
        ["Hello", "Hey there", ]
    ],
    [
        r"(.*) crowd(.*)?",
        ["Yes, you can come after some time", "No, its quiet here"]
    ],
    [
        r"Which snacks (.*)?",
        ["Dosa, Idli Sambar, Vadapav and many more..."]
    ],
    [
        r"What is (rate|cost) of (.*)?",
        ["%2 is for Rs 10","%2 is for Rs 100","%2 is for Rs 15"]
    ],
    [
        r"sorry (.*)",
        ["Its alright", "Its OK, never mind", ]
    ],
    [
        r"(I am|I'm) fine",
        ["Great to hear that, How can I help you?", ]
    ],
 
    [
        r"What time (.*) close?",
        ["We close at 11pm", ]
    ],
    [
        r"i'm (.*) doing good",
        ["Nice to hear that", "How can I help you?:)", ]
    ],
    [
        r"(.*) created ?",
        ["Sanket created me using Python's NLTK library ", "top secret ;)", ]
    ],
    [
        r"(.*) (location|city) ?",
        ['Katraj, Pune', ]
    ],
    [
        r"how is weather in (.*)?",
        ["Weather in %1 is awesome like always", "Too hot man here in %1",
            "Too cold man here in %1", "Never even heard about %1"]
    ],
    [
        r"quit|bye",
        ["BBye take care. See you soon :) ",
            "It was nice talking to you. See you soon :)"]
    ],
]
 
 
def chat():
    print("Hi! Welcome to Siddhivinayak snacks center. Here at your service. How can I help you?")
    chat = Chat(pairs, reflections)
    chat.converse()
 
 
if __name__ == "__main__":
    chat()