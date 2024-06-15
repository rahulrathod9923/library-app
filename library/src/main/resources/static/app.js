const bookApiUrl = 'http://localhost:8080/books';
const userApiUrl = 'http://localhost:8080/users';

document.addEventListener('DOMContentLoaded', () => {
    document.getElementById('books-btn').addEventListener('click', showBooksSection);
    document.getElementById('users-btn').addEventListener('click', showUsersSection);

    // Show books section by default
    showBooksSection();

    getBooks();
    getUsers();
});

function showBooksSection() {
    document.getElementById('books-section').style.display = 'block';
    document.getElementById('users-section').style.display = 'none';
}

function showUsersSection() {
    document.getElementById('books-section').style.display = 'none';
    document.getElementById('users-section').style.display = 'block';
}

function getBooks() {
    fetch(`${bookApiUrl}/fetchAll`)
        .then(response => response.json())
        .then(data => {
            const booksDiv = document.getElementById('books');
            booksDiv.innerHTML = '';
            data.forEach(book => {
                booksDiv.innerHTML += `
                    <div class="book">
                        <h3>${book.bookName} by ${book.author}</h3>
                        <button onclick="updateBook(${book.id})">Update</button>
                        <button onclick="deleteBook(${book.id})">Delete</button>
                    </div>
                `;
            });
        })
        .catch(error => console.error('Error:', error));
}

function createBook() {
    const bookName = document.getElementById('book-bookName').value;
    const author = document.getElementById('book-author').value;

    fetch(`${bookApiUrl}/create`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ bookName, author })
    })
    .then(response => response.json())
    .then(() => {
        getBooks();
        document.getElementById('book-bookName').value = '';
        document.getElementById('book-author').value = '';
    })
    .catch(error => console.error('Error:', error));
}

function updateBook(id) {
    const bookName = prompt('Enter new book name');
    const author = prompt('Enter new author');

    fetch(`${bookApiUrl}/update/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ bookName, author })
    })
    .then(() => getBooks())
    .catch(error => console.error('Error:', error));
}

function deleteBook(id) {
    fetch(`${bookApiUrl}/delete/${id}`, {
        method: 'DELETE'
    })
    .then(() => getBooks())
    .catch(error => console.error('Error:', error));
}

function getUsers() {
    fetch(`${userApiUrl}/fetchAll`)
        .then(response => response.json())
        .then(data => {
            const usersDiv = document.getElementById('users');
            usersDiv.innerHTML = '';
            data.forEach(user => {
                usersDiv.innerHTML += `
                    <div class="user">
                        <h3>${user.nameOfUser}</h3>
                        <p>Book: ${user.bookName} by ${user.author}</p>
                        <p>Date of Issue: ${user.dateOfIssue}</p>
                        <p>Date of Return: ${user.returnDate}</p>
                        <button onclick="updateUser(${user.id})">Update</button>
                        <button onclick="deleteUser(${user.id})">Delete</button>
                    </div>
                `;
            });
        })
        .catch(error => console.error('Error:', error));
}

function createUser() {
    const nameOfUser = document.getElementById('user-nameOfUser').value;
    const bookName = document.getElementById('user-bookName').value;
    const author = document.getElementById('user-author').value;
    const dateOfIssue = document.getElementById('user-dateOfIssue').value;
    const returnDate = document.getElementById('user-returnDate').value;

    fetch(`${userApiUrl}/create`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nameOfUser, bookName, author, dateOfIssue, returnDate })
    })
    .then(response => response.json())
    .then(() => {
        getUsers();
        document.getElementById('user-nameOfUser').value = '';
        document.getElementById('user-bookName').value = '';
        document.getElementById('user-author').value = '';
        document.getElementById('user-dateOfIssue').value = '';
        document.getElementById('user-returnDate').value = '';
    })
    .catch(error => console.error('Error:', error));
}

function updateUser(id) {
    const nameOfUser = prompt('Enter new user name');
    const bookName = prompt('Enter new book name');
    const author = prompt('Enter new author');
    const dateOfIssue = prompt('Enter new date of issue (YYYY-MM-DD)');
    const returnDate = prompt('Enter new date of return (YYYY-MM-DD)');

    fetch(`${userApiUrl}/update/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ nameOfUser, bookName, author, dateOfIssue, returnDate })
    })
    .then(() => getUsers())
    .catch(error => console.error('Error:', error));
}

function deleteUser(id) {
    fetch(`${userApiUrl}/delete/${id}`, {
        method: 'DELETE'
    })
    .then(() => getUsers())
    .catch(error => console.error('Error:', error));
}
