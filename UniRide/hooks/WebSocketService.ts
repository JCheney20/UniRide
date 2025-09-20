import SockJS from 'sockjs-client';
import Stomp from 'stompjs';

// IMPORTANT: Replace with your machine's local IP address
const API_URL = 'http://192.168.1.10:8080';

class WebSocketService {
    stompClient: Stomp.Client;

    connect(onMessageReceived: (message: any) => void) {
        const socket = new SockJS(`${API_URL}/ws`);
        this.stompClient = Stomp.over(socket);

        this.stompClient.connect({}, () => {
            this.stompClient.subscribe('/topic/ride-requests', (message) => {
                onMessageReceived(JSON.parse(message.body));
            });
        });
    }

    disconnect() {
        if (this.stompClient) {
            this.stompClient.disconnect(() => {});
        }
    }
}

export default new WebSocketService();
