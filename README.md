*******************************************************************************************************
How to setup and run:

1.) Copy java files to any number of machines

2.) Open the Util.java file and change the values of IP, PORT, USERNAME according to the machine.
	Change BS_IP, BS_PORT according to the machine running the Bootstrap server

3.) Start Bootstrap server on chosen port in the chosen machine

4.) Compile and Run the java files on each machine:

javac Main.java Node.java BootstrapCommunicator.java NodeSender.java NodeReceiver.java Neighbour.java Util.java

java Main

*******************************************************************************************************

How to operate the distributed system:

The distributed system will automatically register with the Bootstrap server
Then you can enter following commands as necessary (1, 2, 3, 9):
1 - Join the distributed system
2 - Search for file
3 - Leave the distributed system and Unregister from bootstrap server
9 - Exit

If you enter 2 then enter the name or part of the name of the file you want to search.

*******************************************************************************************************

Team Members:

Jayaweera W.J.A.I.U.	100227D
Liyana Arachchi A.I. 	100297N
Sampath P.L.B.	 	100476M
Wijewardane M.M.D.T.K. 	100612E

