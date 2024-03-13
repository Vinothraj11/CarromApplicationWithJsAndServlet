/**
 * 
 */

document.addEventListener('DOMContentLoaded', function() {
	// Make a GET request to the Servlet to get the board info
	fetch('/CarromApplicationWithJsAndServlet/BoardStatusServlet')
		.then(response => {
			if (!response.ok) {
				throw new Error(`HTTP error! Status: ${response.status}`);
			}
			return response.json();
		})
		.then(boardInfo => {
			console.log('Board info ' + boardInfo);
			console.log('White coins ' + boardInfo.whiteCoins);
			document.getElementById('whiteCoin').innerText = boardInfo.whiteCoins;
			document.getElementById('blackCoins').innerText = boardInfo.blackCoins;
			document.getElementById('redCoins').innerText = boardInfo.redCoins;
		})
		.catch(error => {
			console.error('Error fetching board info:', error);
		});
});;