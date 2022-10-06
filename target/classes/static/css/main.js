const TransactType = document.querySelector("#transact-type")
const PaymentCard = document.querySelector(".payment-card")
const TransferCard = document.querySelector(".transfer-card")
const DepositCard = document.querySelector(".deposit-card")
const WithdrawCard = document.querySelector(".withdraw-card")

TransactType.addEventListener("change", () => {

    switch (TransactType.value){
        case "payment":
            PaymentCard.style.display = "block";
            PaymentCard.nextElementSibling.style.display = "none";
            DepositCard.style.display = "none";
            WithdrawCard.style.display = "none";
        break; 
        case "transfer":
            TransferCard.previousElementSibling.style.display = "none"
            TransferCard.style.display = "block"
            TransferCard.nextElementSibling.style.display = "none";
            WithdrawCard.style.display = "none";
       break;
        case "deposit":
            DepositCard.previousElementSibling.style.display = "none"
            DepositCard.style.display = "block"
            DepositCard.nextElementSibling.style.display = "none";
            PaymentCard.style.display = "none";
        break;

        case "withdraw":
            WithdrawCard.previousElementSibling.style.display = "none"
            WithdrawCard.style.display = "block"
            PaymentCard.style.display = "none";
            TransferCard.style.display = "none";
        break;

    }
})


