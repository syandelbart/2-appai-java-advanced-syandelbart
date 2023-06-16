package fact.it.ex1.repository;

import fact.it.ex1.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    @Query("select p from Payment p")
    List<Payment> giveListOfAllPayments();

    @Query("select p from Payment p order by p.amount asc")
    List<Payment> giveListOfAllPaymentsAsc();

    @Query("select p from CashPayment p")
    List<Payment> giveListOfAllPaymentsCash();

    @Query("select p from ElectronicPayment p order by p.currency")
    List<Payment> giveListOfAllPaymentsElecSortedByCurrency();

    List<Payment> findAllByAmountGreaterThan(double amount);
}
