package catalogue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BetterBasketTest {

	@Test
	void testMergeAddProduct() {
		BetterBasket b = new BetterBasket();
		Product p1 = new Product("0001", "Toaster", 10.00, 1);
		Product p2 = new Product("0001", "Toaster", 10.00, 1);
		Product p3 = new Product("0002", "Kettle", 15.00, 1);
		Product p4 = new Product("0002", "kettle", 15.00, 2);
		
		b.add(p1);
		b.add(p2);
		assertEquals(1, b.size(), "Size incorrect after merge");
		assertEquals(2, b.get(0).getQuantity(), "Quantity incorrect after merge");
		
		b.add(p3);
		assertEquals(2, b.size(), "Size incorrect after non-merge");
		
		b.add(p4);
		assertEquals(3, b.get(1).getQuantity(), "Quantity incorrect after merge");
	}	
	
	@Test
	void testSortAddProduct() {
		BetterBasket b = new BetterBasket();
		Product p1 = new Product("0001", "Toaster", 10.00, 1);
		Product p2 = new Product("0002", "Microwave", 50.00, 1);
		Product p3 = new Product("0003", "Kettle", 15.00, 1);
		
		//testing that p1 and p3 get sorted 
		
		b.add(p3);
		b.add(p1);
		assertEquals("0001", b.get(0).getProductNum(), "Product missorted");
		assertEquals("0003", b.get(1).getProductNum(), "Product missorted");
		
		//testing that p2 gets inserted
		b.add(p2);
		assertEquals("0001", b.get(0).getProductNum(), "Product incorrect after insert");
		assertEquals("0002", b.get(1).getProductNum(), "Product incorrect after insert");
		assertEquals("0003", b.get(2).getProductNum(), "Product incorrect after insert");
		
	}


	@Test
	void testSortRemovalOfProduct () {
		BetterBasket b2 = new BetterBasket();
		
		Product p1 = new Product("0001", "Toaster", 10.00, 2);
		Product p2 = new Product("0002", "Kettle", 15.00, 3);
		
		b2.add(p1);
		b2.add(p2);
		
		//confirm initial basket size of any removals
		assertEquals(2, b2.size(), "Basket should contain two products - initial state");
		//remove one quantity of product from basket
		assertTrue(b2.remove(new Product("0001", "Toaster", 10.00, 1)), "Failed to reduce quantity of p1");
		//confirm basket's state after partial removal of p1
		assertEquals(2, b2.size(), "Basket contains 2 prods");
		
	}
	 

	
	
	

}
