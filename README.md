#GIT URL
https://github.com/tuhindaw/tuhin-core-java-projects.git

Clone the project using below command
git clone https://github.com/tuhindaw/tuhin-core-java-projects.git

Prerequisites:
JAVA 8

# Run

This being a simple core java project, there is no additional setup to run this program. Just import the project in your favourite IDE and run the test class CarRentalUnitTest.java
which provides junit test cases to cover almost all its features. There is also a class Test.java provided to test some of its features. Ideally one should execute its junit test class
CarRentalUnitTest.java to test the functionality.

Approach towards solution:

I have tried to implement the car rental services based on two approaches. For simplicity purpose, car rental service is designed based on single node or single service location.
        1) Simple approach by implementing core features of a car rental service using only core java.
        2)A reinforcement learning technique based on AIML

Approach 1 : As already stated, core features can be tested using the junit class CarRentalUnitTest.java

Approach 2 : Reinforcement learning technique based on AIML : Machine Learning layer to optimize Car rental profit


A major concern of a Car rental services is how many  cars to keep in stock from the other nodes and suppliers to meet the customer demand and at the same time minimize his costs. The Car Rental service owner needs to learn the demand pattern and car booking rate accordingly. What if he was given a reinforcement learning agent who would learn from history how the demand has been and place for cars (fleeting cars from other nodes)  accordingly.

 •	In a reinforcement learning problem, an agent learns how to behave in an environment by taking actions and seeing the consequences - rewards and change in state.
 •	The control objective of the agent is to learn a policy to accumulate maximum rewards over a period of time.
 •	The entire reinforcement learning problem is based on the Markov assumption: the current state contains all relevant information to take the future action.

 Thought to ponder: Why not apply time series prediction and predict the future demand?

 We could. But every few months the market conditions change. Will you apply time-series every month to adjust to the latest conditions? Reinforcement learning agent will constantly learn from the environment and update its demand curve.
 The state in Markov Decision Process is: (Car Inventory size, Distance cars traveling , day-of-the-week). Basis these Three features, the car Rental agent can decide how many cars they should fleet to their own node or service station. We'll consider this state as Markovian.
 Let’s assume Car rental service only like to predict demand to understand keep his stock ready for maximizing profit. Let’s assume all other variables are control by environment.
 So the action Rental service will take every day  at 6 PM evening to order cars from other node
 To their own node to support next day demand. Let’s define total reward for a car rental service

    •	Buying cost from the supplier (b) – Rental Service needs to spend cost to fleet cars from other nodes or service stations.
    •	Holding cost (d) – Rental service needs to pay rent for parking cars area.
    •	Return cost (r) – Sometime Demand is less but no of cars(order at evening + in stock cars) are more and space of parking less .So rental service needs to return extra cars . This involves cost.
    •	Delivery cost (s) – Rental Company also need to pay for fleeting vehicles.
    •	Opportunity cost (o) – Sometime demands will be more than supply . So Rental agents needs to turn down offer from Customers .
    •	Profit (p) – Rental charge – (b+d+r+s+o).

Goal of Reinforcement Learning agent to predict demand to maximize profit. If Inventory has 100 cars and rental agent order 100 more cars everyday (without any calculation) and demand is X(need to understand ) Then (100 + 100-X ) is remaining car in inventory next day . if X is greater than 200 then rental service agent needs to pay opportunity cost . If (200 – X ) is greater than rental space available then rental agent need to pay
Return cost. We will use classical RL to resolve this problem and fundamental equitation will be

     •	Policy π(a|s)
     •	State-value: v(s)
     •	q-value: q(s,a)

Define State value  like vπ(s)=∑a∼π(a|s)π(a|s)qπ(s,a)
Define Action Value/Q value  like qπ(s,a)=∑s′∑rp(s′,r|s,a)(r+γvπ(s′))
     •	q-value- an estimate of the value of an action, that can be performed, in a given state.
     •	state-value- an estimate of the value of the state, by taking the weighted sum of the expected value of all the actions.

The classes to implemet the Reinforcement Learning algorithm are provided in package 'artificialintelligence'

Conclusion : This is not a full proof solution but gives an idea around basic features of a simple car rental service.. On addition to this,
an idea has also been provided how AIML Reinforcement Learning algorithm can be applied to design a large scale optimal car rental service.




