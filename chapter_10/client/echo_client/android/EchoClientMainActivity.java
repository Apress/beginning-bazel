package client.echo_client.android;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import transmission_object.TransmissionObjectOuterClass.TransmissionObject;
import transceiver.TransceiverOuterClass.EchoRequest;
import transceiver.TransceiverOuterClass.EchoResponse;
import transceiver.TransceiverGrpc;

public class EchoClientMainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.echo_client_main_activity);

        Button textSenderButton = findViewById(R.id.text_sender);
        EditText clientTextEditor = findViewById(R.id.text_input);
        TextView serverResultsText = findViewById(R.id.server_result_text);

        textSenderButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String clientText = clientTextEditor.getText().toString();
                if (!clientText.isEmpty()) {
                    ManagedChannel channel = ManagedChannelBuilder.forAddress("10.0.2.2", 1234)
                        .usePlaintext()
                        .build();
                    TransceiverGrpc.TransceiverBlockingStub stub = TransceiverGrpc.newBlockingStub(channel);
                    EchoRequest request = EchoRequest.newBuilder().setFromClient(
                        TransmissionObject.newBuilder()
                            .setMessage(clientText)
                            .setValue(3.145f).build())
                            .build();
                    try {
                        EchoResponse response = stub.echo(request);
                        serverResultsText.setText(response.toString());
                    } catch (Throwable t) {
                        Log.d("EchoClientMainActivity", "error:", t);
                    } finally {
                        channel.shutdown();
                    }
                }
            }
        });
    }
}