$('document').ready(() => {
  function updateMessages() {
    console.log('Update Messages');
    $.ajax({
      url: '/messages',
      method: 'GET',
    }).done(({ data }) => {
      console.log(data);
      $('#messages').html('');
      console.log('Cleared html');

      $('#messageNumber').html(`
      <h3>
        You have ${data.length} messages
      </h3>
      `);
      console.log('Updated number');

      data.map((message) => {
        $('#messages').append(`
        <h5>${message.sender} said:</h5>
        <p>${message.message}</p>
        <p
        class="text-primary deleteButton" 
        messageId="${message.id}"
        style="cursor: pointer"
        >
        Delete
        </p>
        `);
      });
      console.log('Mapped Messages');
    });
  }

  $('#messages').on('click', '.deleteButton', function () {
    let messageId = $(this).attr('messageId');
    console.log(messageId);
    $.ajax({
      url: `/message/delete/${messageId}`,
      method: 'DELETE',
    }).done(updateMessages());
  });
});
