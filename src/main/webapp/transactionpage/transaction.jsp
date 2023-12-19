    <%--
      Created by IntelliJ IDEA.
      User: Moderator
      Date: 10/16/2023
      Time: 2:45 AM
      To change this template use File | Settings | File Templates.
    --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css">
        <title>Winzbanking Transactions</title>
    </head>
    <body>
    <header>
        <h1>Winzbanking Transactions</h1>
    </header>
    <main>
        <section class="account">
            <h2>My Accounts</h2>
            <ul>
                <li>
                    <strong>Account 1:</strong>
                    <span>$1,000</span>
                </li>
                <li>
                    <strong>Account 2:</strong>
                    <span>$2,500</span>
                </li>
                <!-- More account entries -->
            </ul>
        </section>
        <section class="transactions">
            <h2>Recent Transactions</h2>
            <table>
                <tr>
                    <th>Date</th>
                    <th>Transaction Type</th>
                    <th>Amount</th>
                </tr>
                <tr>
                    <td>2023-10-16</td>
                    <td>Deposit</td>
                    <td>$500</td>
                </tr>
                <!-- More transaction entries -->
            </table>
            <button id="transferButton">Transfer Money</button>
            <button id="payBillButton">Pay Bill</button>
            <button id="withdrawButton">Withdraw Money</button>
            <button id="depositButton">Deposit Money</button>
        </section>
    </main>
    <footer>
        &copy; 2023 Winzbanking
    </footer>
    </body>
    </html>
