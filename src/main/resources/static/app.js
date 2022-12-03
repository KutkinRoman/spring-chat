var stompClient = null;

function initAppHandler(){
    socketConnectHandle();
    initMessagesHandler();
}

function sendMessageHandler(){
    const newMessageInput = document.getElementById('newMessageInput');
    const newMessage = {text: newMessageInput.value};
    newMessageInput.value = null;
    stompClient.send("/app/message", {}, JSON.stringify(newMessage));
}

function addMessageHandler(message){
    const messages = document.getElementById('messages');
    const messageComponent = createMessageComponent(message);
    messages.innerHTML = messageComponent + messages.innerHTML;
}

function socketConnectHandle() {
    var socket = new SockJS('/register-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        stompClient.subscribe('/chat', function (message) {
            addMessageHandler(JSON.parse(message.body));
        });
    });
}

async function initMessagesHandler(){
    const response = await fetch('/messages/getAll');
    const messages = await response.json();
    for (const message of messages) {
        addMessageHandler(message)
    }
}

function createMessageComponent(message){
    return `
    <div class="card" id="message_${message.id}">
        <div class="card-body">
            <h5 class="card-title">${message.id}</h5>
            <p class="card-text">${message.text}</p>
        </div>
    </div>
    `
}


