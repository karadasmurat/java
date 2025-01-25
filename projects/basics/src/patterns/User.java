public class User {
    private String firstName;
    private String lastName;
    private int age;

    User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private int age;

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this; // Returning 'this' enables chaining
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this; // Returning 'this' enables chaining
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this; // Returning 'this' enables chaining
        }

        public User build() {
            return new User(firstName, lastName, age);
        }
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }
}