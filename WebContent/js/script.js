document.addEventListener("DOMContentLoaded", function(event) {
    let table = document.getElementById("table-items")
    if(table.rows.length < 2 ) {
        table.style.display = "none"
        document.getElementById("notification-msg").innerHTML = 'No items in cart. Use \'Add to Cart\' option in <a href="menu-item-list-customer.html">Menu Item List</a>.'
        displayNotification()
    }
});



function deleteCartItem() {
    displayNotification()
}

function displayNotification() {
    document.getElementById("notification-msg").style.display = "block"
}