package model;

public class Account
{
    private final String username;
    private final String password;
    private final String recovery;
    private final String company;

    public static class Builder
    {
        private final String username;
        private final String password;
        private String company;
        private String recovery;
        public Builder(String username, String password)
        {
            this.username = username;
            this.password = password;
            this.company = "";
            this.recovery = "";
        }

        public Builder company(String val)
        {
            this.company = val;
            return this;
        }

        public Builder recovery(String val)
        {
            this.recovery = val;
            return this;
        }

        public Account build()
        {
            return new Account(this);
        }

    }

    public Account(Builder builder)
    {
        this.username = builder.username;
        this.password = builder.password;
        this.recovery = builder.recovery;
        this.company = builder.company;
    }

    public String getCompany()
    {
        return company;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getRecovery()
    {
        return recovery;
    }

    @Override
    public String toString()
    {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", recovery='" + recovery + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}