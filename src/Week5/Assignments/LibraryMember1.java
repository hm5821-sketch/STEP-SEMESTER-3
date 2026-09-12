package Week5.Assignments;

public class LibraryMember1 {
    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String hashedSecurityAnswer;

    // Public no-argument constructor
    public LibraryMember1() {}

    // Write-once property for membershipId
    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String id) {
        if (this.membershipId == null) {
            this.membershipId = id;
        }
    }

    // Standard getters/setters for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Boolean JavaBean convention using isX()
    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premiumMember) {
        this.premiumMember = premiumMember;
    }

    // Write-only property: setter exists, but no getter is provided anywhere
    public void setSecurityAnswer(String answer) {
        if (answer != null) {
            this.hashedSecurityAnswer = simpleHash(answer);
        }
    }

    private String simpleHash(String input) {
        int hash = 7;
        for (int i = 0; i < input.length(); i++) {
            hash = hash * 31 + input.charAt(i);
        }
        return "HASH_" + hash;
    }
}