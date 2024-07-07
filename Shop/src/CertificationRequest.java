public class CertificationRequest {
    private Seller seller;
    private String name;
    private String address;

    public CertificationRequest(Seller seller, String name, String address) {
        this.seller = seller;
        this.name = name;
        this.address = address;
    }

    public Seller getSeller() {
        return seller;
    }
    public void approve() {
        seller.setCertified(true);
    }
    public void reject() {
        seller.setCertified(false);
    }
}
