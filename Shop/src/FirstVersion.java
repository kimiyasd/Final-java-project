public class FirstVersion {

    public static void start() {
        OnlineShop shop = new OnlineShop("MyShop", "www.myshop.com", new LoginDatas(),null);
        shop.phoneNumber = "123456789";

        Admin admin = new Admin("admin", "admin", shop);
        shop.setMainAdmin(admin);
        User buyer = new User("kimiya", "1234", new Wallet(12500.0),shop);

        Seller digikala = new Seller("digikala","1234", new Wallet(1200.0),shop,true);
        Seller whitefox = new Seller("whitefox","1234", new Wallet(500.0),shop,true);

        Furniture sofa = new Furniture("red sofa", 780, 5, digikala,new String[]{"I won't purchase again","It's not comfortable tbh"});
        Furniture bed = new Furniture("wooden bed", 1300, 5, whitefox,new String[]{"sth really casual^^"});
        Fruit banana = new Fruit("banana", 5, 5, digikala,new String[]{"It's a 10/10 in my POV"});
        Fruit ananas = new Fruit("ananas", 8, 5, digikala,new String[]{"i'd definitely purchase again"});
        Fruit mango = new Fruit("mango", 10, 5, digikala,new String[]{"so fresh!!"});
        Clothing top = new Clothing("crop top", 51, 3,36, whitefox,new String[]{"the color got me"});
        Clothing jeans = new Clothing("momfit jean", 120, 15,38, whitefox,new String[]{"sooo gorgeous"});
        ElectronicsProduct watch = new ElectronicsProduct("iwatch Ultra 8", 700, 10, digikala,new String[]{"it was a rip-off"});
        ElectronicsProduct phone = new ElectronicsProduct("iphone", 1100, 10, whitefox,new String[]{"i'd recommend you to buy this item."});
        Book me_before_you = new Book("me before you", 20, 10,"jojo", digikala,new String[]{"amazingggg","i suggest everyone to read this!" });
        Book twilight = new Book("twilight", 22, 10,"meyer", digikala,new String[]{"not my type"});
        Book bible = new Book("the bible", 30, 10,"god", digikala,new String[]{"fabulous!!","i wish you had other books,too."});
        shop.stock.addProduct(watch);
        shop.stock.addProduct(phone);
        shop.stock.addProduct(sofa);
        shop.stock.addProduct(banana);
        shop.stock.addProduct(ananas);
        shop.stock.addProduct(mango);
        shop.stock.addProduct(jeans);
        shop.stock.addProduct(top);
        shop.stock.addProduct(bed);
        shop.stock.addProduct(me_before_you);
        shop.stock.addProduct(twilight);
        shop.stock.addProduct(bible);
        IntroPage.Intro(shop);
    }
}
