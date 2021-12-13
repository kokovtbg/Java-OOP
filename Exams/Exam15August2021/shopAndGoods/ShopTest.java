package Exams.Exam15August2021.shopAndGoods;


import org.junit.Assert;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ShopTest {
    @Test
    public void testGetShelves() {
        Shop shop = new Shop();
        Assert.assertEquals(12, shop.getShelves().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddOperationThrowsExceptionOnNoShelf() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("Nikola", "Nikola");
        shop.addGoods("Nikola", goods);
    }

    @Test
    public void testAddOperationSuccessful() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("Nikola", "Nikola");
        shop.addGoods("Shelves1", goods);
        Assert.assertEquals(goods, shop.getShelves().get("Shelves1"));
        Assert.assertEquals(12, shop.getShelves().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddOperationThrowsIllegalEx() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("Nikola", "Nikola");
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves1", goods);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddOperationThrowsOperationNotSupportedEx() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("Nikola", "Nikola");
        shop.addGoods("Shelves1", goods);
        shop.addGoods("Shelves2", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveOperationThrowsIllArgumentEx() {
        Shop shop = new Shop();
        Goods goods = new Goods("Nikola", "Nikola");
        shop.removeGoods("Nikola", goods);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveOperationThrowsIllegalArgumentEx() {
        Shop shop = new Shop();
        Goods goods = new Goods("Nikola", "Nikola");
        shop.removeGoods("Shelves1", goods);
    }

    @Test
    public void testRemoveOperationSuccessful() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("Nikola", "Nikola");
        shop.addGoods("Shelves1", goods);
        shop.removeGoods("Shelves1", goods);
        Assert.assertNull(shop.getShelves().get("Shelves1"));
        Assert.assertEquals(12, shop.getShelves().size());
    }

    @Test
    public void testRemoveOperationSuccessfulPrintMessage() throws OperationNotSupportedException {
        Shop shop = new Shop();
        Goods goods = new Goods("Nikola", "Nikola");
        shop.addGoods("Shelves1", goods);
        Assert.assertEquals(String.format("Goods: %s is removed successfully!", goods.getGoodsCode()), shop.removeGoods("Shelves1", goods));
    }
}