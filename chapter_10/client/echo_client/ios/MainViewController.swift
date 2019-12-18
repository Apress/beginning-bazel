import UIKit
import proto_transmission_object_proto
import proto_transceiver_proto
import proto_transceiver_swift_proto_grpc

public class MainViewController : UIViewController {

    private let textInput = UITextField()
    private let sendButton =  UIButton(type: UIButton.ButtonType.system)
    private let receivedText = UILabel()

    override public func viewDidLoad() {
        super.viewDidLoad()

        self.view.backgroundColor = .white

        textInput.placeholder = "Input text here"
        textInput.textColor = UIColor.black
        textInput.backgroundColor = UIColor.white
        textInput.isEnabled = true

        sendButton.setTitle("Send", for: UIControl.State.normal)
        sendButton.addTarget(self, action: #selector(send), for: .touchUpInside)
        sendButton.isEnabled = true

        receivedText.numberOfLines = 0
        receivedText.text = "Received text will show up here."
        receivedText.backgroundColor = .gray
        receivedText.textColor = .black

        let stackView = UIStackView(arrangedSubviews: [self.textInput, self.sendButton, self.receivedText])
        stackView.alignment = .fill
        stackView.axis = .vertical
        stackView.distribution = .fillEqually
        stackView.spacing = 10.0
        stackView.translatesAutoresizingMaskIntoConstraints = false

        self.view.addSubview(stackView)
    }

    override public func viewDidAppear(_ animated: Bool) {
        super.viewDidAppear(animated)
        textInput.text = ""
        receivedText.text = ""
    }

    @objc func send(sender: UIButton!) {
//        receivedText.text = textInput.text
        let client = Transceiver_TransceiverServiceClient(address: "localhost:1234", secure: false)

        var transmissionObject = TransmissionObject_TransmissionObject()
        transmissionObject.message = textInput.text ?? ""
        transmissionObject.value = 3.14

        var request = Transceiver_EchoRequest()
        request.fromClient = transmissionObject

        let response = try? client.echo(request)
        if let response = response {
            receivedText.text = response.fromServer.textFormatString()
        }
    }
}
