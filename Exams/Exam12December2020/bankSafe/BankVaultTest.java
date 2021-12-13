package Exams.Exam12December2020.bankSafe;


import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

public class BankVaultTest {

    //TODO: Write your tests here
    @Test
    public void testCreateSuccessful() {
        BankVault bankVault = new BankVault();
        Assert.assertEquals(12, bankVault.getVaultCells().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemThrowsWhenNoSuchCell() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Nikola", "123");
        bankVault.addItem("e", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddItemThrowsExWhenCellNotNull() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Nikola", "123");
        bankVault.addItem("A1", item);
        Item item1 = new Item("Nikola", "1234");
        bankVault.addItem("A1", item1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddItemThrowsWhenItemAlreadyInBank() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Nikola", "123");
        bankVault.addItem("A1", item);
        bankVault.addItem("A2", item);
    }

    @Test
    public void testAddItemSuccessful() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Nikola", "123");
        bankVault.addItem("A1", item);
        Assert.assertEquals(item, bankVault.getVaultCells().get("A1"));
        Assert.assertEquals(12, bankVault.getVaultCells().size());
        Assert.assertEquals("Nikola", bankVault.getVaultCells().get("A1").getOwner());
        Assert.assertEquals("123", bankVault.getVaultCells().get("A1").getItemId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveThrowsWhenCellDoesNotExist() {
        BankVault bankVault = new BankVault();
        Item item = new Item("Nikola", "123");
        bankVault.removeItem("A", item);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveThrowsWhenItemDoesNotExist() {
        BankVault bankVault = new BankVault();
        Item item = new Item("Nikola", "123");
        bankVault.removeItem("A1", item);
    }

    @Test
    public void testRemoveSuccessful() throws OperationNotSupportedException {
        BankVault bankVault = new BankVault();
        Item item = new Item("Nikola", "123");
        bankVault.addItem("A1", item);
        Assert.assertEquals("Remove item:123 successfully!", bankVault.removeItem("A1", item));;
        Assert.assertNull(bankVault.getVaultCells().get("A1"));
        for (Map.Entry<String, Item> entry : bankVault.getVaultCells().entrySet()) {
            Assert.assertNull(entry.getValue());
        }
        Assert.assertEquals(12, bankVault.getVaultCells().size());
    }
}