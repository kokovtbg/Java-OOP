package TestDrivenDevelopment.exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChainblockImpl implements Chainblock {
    private List<Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new ArrayList<>();
    }

    public int getCount() {
        return this.transactions.size();
    }

    public void add(Transaction transaction) {
        int id = transaction.getId();
        boolean canAddTransaction = true;
        for (int i = 0; i < this.transactions.size(); i++) {
            if (this.transactions.get(i).getId() == id) {
                canAddTransaction = false;
                break;
            }
        }
        if (canAddTransaction) {
            this.transactions.add(transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        int id = transaction.getId();
        for (int i = 0; i < this.transactions.size(); i++) {
            if (this.transactions.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(int id) {
        for (int i = 0; i < this.transactions.size(); i++) {
            if (this.transactions.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        boolean changedStatus = false;
        for (int i = 0; i < this.transactions.size(); i++) {
            if (this.transactions.get(i).getId() == id) {
                this.transactions.get(i).setStatus(newStatus);
                changedStatus = true;
                break;
            }
        }
        if (!changedStatus) {
            throw new IllegalArgumentException("No Transaction with given ID");
        }
    }

    public void removeTransactionById(int id) {
        boolean removedTransaction = false;
        for (int i = 0; i < this.transactions.size(); i++) {
            if (this.transactions.get(i).getId() == id) {
                this.transactions.remove(i);
                removedTransaction = true;
                break;
            }
        }
        if (!removedTransaction) {
            throw new IllegalArgumentException("No Transaction with given ID");
        }
    }

    public Transaction getById(int id) {
        for (int i = 0; i < this.transactions.size(); i++) {
            if (this.transactions.get(i).getId() == id) {
                return this.transactions.get(i);
            }
        }
        throw new IllegalArgumentException("No Transaction with given ID");
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = new ArrayList<>();
        this.transactions.stream()
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .filter(t -> t.getStatus().equals(status))
                .forEach(transactions::add);
        if (transactions.size() > 0) {
            return transactions;
        }
        throw new IllegalArgumentException("No Transaction with given status");

    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> transactions = new ArrayList<>();
        this.transactions.stream()
                .filter(t -> t.getStatus().equals(status))
                .forEach(t -> transactions.add(t.getFrom()));
        if (transactions.size() > 0) {
            return transactions;
        }
        throw new IllegalArgumentException("No Transaction with given status");
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> transactions = new ArrayList<>();
        this.transactions.stream()
                .filter(t -> t.getStatus().equals(status))
                .forEach(t -> transactions.add(t.getTo()));
        if (transactions.size() > 0) {
            return transactions;
        }
        throw new IllegalArgumentException("No Transaction with given status");
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        List<Transaction> transactions = new ArrayList<>();
        this.transactions.stream()
                .sorted((t1, t2) -> {
                    int result = Double.compare(t2.getAmount(), t1.getAmount());
                    if (result == 0) {
                        result = Integer.compare(t1.getId(), t2.getId());
                    }
                    return result;
                }).forEach(transactions::add);
        return transactions;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactions = new ArrayList<>();
        this.transactions.stream()
                .filter(t -> t.getFrom().equals(sender))
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .forEach(transactions::add);
        if (transactions.size() > 0) {
            return transactions;
        }
        throw new IllegalArgumentException("No transaction with given sender");
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactions = new ArrayList<>();
        this.transactions.stream()
                .filter(t -> t.getTo().equals(receiver))
                .sorted((t1, t2) -> {
                    int result = Double.compare(t2.getAmount(), t1.getAmount());
                    if (result == 0) {
                        result = Integer.compare(t1.getId(), t2.getId());
                    }
                    return result;
                }).forEach(transactions::add);
        if (transactions.size() > 0) {
            return transactions;
        }
        throw new IllegalArgumentException("No Transaction with given receiver");
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        List<Transaction> transactions = new ArrayList<>();
        this.transactions.stream()
                .filter(t -> t.getStatus().equals(status))
                .filter(t -> t.getAmount() <= amount)
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .forEach(transactions::add);
        return transactions;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactions = new ArrayList<>();
        this.transactions.stream()
                .filter(t -> t.getFrom().equals(sender))
                .filter(t -> t.getAmount() > amount)
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .forEach(transactions::add);
        if (transactions.size() > 0) {
            return transactions;
        }
        throw new IllegalArgumentException("No Transaction with given Sender or Amount");
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactions = new ArrayList<>();
        this.transactions.stream()
                .filter(t -> t.getTo().equals(receiver))
                .filter(t -> t.getAmount() >= lo && t.getAmount() < hi)
                .sorted((t1, t2) -> {
                    int result = Double.compare(t2.getAmount(), t1.getAmount());
                    if (result == 0) {
                        result = Integer.compare(t1.getId(), t2.getId());
                    }
                    return result;
                }).forEach(transactions::add);
        if (transactions.size() > 0) {
            return transactions;
        }
        throw new IllegalArgumentException("No Transaction with given Receiver or Amount");
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        List<Transaction> transactions = new ArrayList<>();
        this.transactions.stream()
                .filter(t -> t.getAmount() >= lo && t.getAmount() <= hi)
                .forEach(transactions::add);
        return transactions;
    }

    public Iterator<Transaction> iterator() {
        return this.transactions.iterator();
    }
}
