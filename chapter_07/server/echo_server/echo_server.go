package main

import (
	"fmt"
	"log"
	"net"
	"transmission_object"

	"github.com/golang/protobuf/proto"
)

func main() {
	log.Println("Spinning up the Echo Server in Go...")
	listen, error := net.Listen("tcp", ":1234")
	if error != nil {
		log.Panicln("Unable to listen: " + error.Error())
	}
	defer listen.Close()

	connection, error := listen.Accept()
	if error != nil {
		log.Panicln("Cannot accept a connection! Error: " + error.Error())
	}

	log.Println("Receiving on a new connection")
	defer connection.Close()
	defer log.Println("Connection now closed for realz.")

	buffer := make([]byte, 2048)
	size, error := connection.Read(buffer)
	if error != nil {
		log.Panicln("Unable to read from the buffer! Error: " + error.Error())
	}
	data := buffer[:size]
	transmissionObject := &transmission_object.TransmissionObject{}
	error = proto.Unmarshal(data, transmissionObject)
	if error != nil {
		log.Panicln("Unable to unmarshal the buffer! Error: " + error.Error())
	}

	log.Println("Message = " + transmissionObject.GetMessage())
	log.Println("Value = " + fmt.Sprintf("%f", transmissionObject.GetValue()))

	transmissionObject.Message = "Echoed from Go: " + transmissionObject.GetMessage()
	transmissionObject.Value = 2 * transmissionObject.GetValue()

	message, error := proto.Marshal(transmissionObject)
	if error != nil {
		log.Panicln("Unable to marshal the object! Error: " + error.Error())
	}
	connection.Write(message)
}
