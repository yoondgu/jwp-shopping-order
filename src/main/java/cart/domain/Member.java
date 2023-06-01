package cart.domain;

import cart.dao.entity.MemberEntity;

public class Member {
    private final Long id;
    private final String email;
    private final String password;

    public Member(final Long id, final String email, final String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Member(final long id) {
        this(id, null, null);
    }

    public static Member from(final MemberEntity member) {
        return new Member(
                member.getId(),
                member.getEmail(),
                member.getPassword());
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean checkPassword(final String password) {
        return this.password.equals(password);
    }
}
