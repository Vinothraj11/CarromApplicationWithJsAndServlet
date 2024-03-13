/**
 * 
 */

 document.addEventListener('DOMContentLoaded', function() {
    // Make a GET request to the Servlet to get player information
    fetch('/CarromApplicationWithJsAndServlet/PlayerInfoServlet')
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! Status: ${response.status}`);
            }
            return response.json();
        })
        .then(playersInfo => {
            // Render player1 and player2 information in the HTML
            renderPlayerInfo(playersInfo.player1, 'player1');
            renderPlayerInfo(playersInfo.player2, 'player2');
        })
        .catch(error => {
            console.error('Error fetching player information:', error);
        });
});

function renderPlayerInfo(playerInfo, playerIdPrefix) {
    // Update the HTML content with player information
    document.getElementById(`${playerIdPrefix}Name`).innerText = playerInfo.name;
    document.getElementById(`${playerIdPrefix}Score`).innerText = playerInfo.score;
}
