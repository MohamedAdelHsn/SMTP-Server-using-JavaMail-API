# SMTP-Server-using-JavaMail-API
Email is emerging as one of the most valuable services on the internet today. Most of the internet systems use SMTP as a method to transfer mail from one user to another. SMTP is a push protocol and is used to send the mail whereas POP (post office protocol) or IMAP (internet message access protocol) are used to retrieve those mails at the receiver’s side.

# SMTP Fundamentals 
SMTP is an application layer protocol. The client who wants to send the mail opens a TCP connection to the SMTP server and then sends the mail across the connection. The SMTP server is always on listening mode. As soon as it listens for a TCP connection from any client, the SMTP process initiates a connection on that port (25). After successfully establishing the TCP connection the client process sends the mail instantly.

# SMTP Protocol
The SMTP model is of two type :

End-to- end method
Store-and- forward method
The end to end model is used to communicate between different organizations whereas the store and forward method are used within an organization. A SMTP client who wants to send the mail will contact the destination’s host SMTP directly in order to send the mail to the destination. The SMTP server will keep the mail to itself until it is successfully copied to the receiver’s SMTP.
The client SMTP is the one which initiates the session let us call it as the client- SMTP and the server SMTP is the one which responds to the session request and let us call it as receiver-SMTP. The client- SMTP will start the session and the receiver-SMTP will respond to the request.

# Some SMTP Commands:
HELO – Identifies the client to the server, fully qualified domain name, only sent once per session
MAIL – Initiate a message transfer, fully qualified domain of originator
RCPT – Follows MAIL, identifies an addressee, typically the fully qualified name of the addressee and for multiple addressees use one RCPT for each addressee
DATA – send data line by line
This article is contributed by Monika Singh

 # look at image 
![smtp-flow](https://user-images.githubusercontent.com/58120325/75764563-b68cdc00-5d46-11ea-9d67-44336ab766e9.png)




