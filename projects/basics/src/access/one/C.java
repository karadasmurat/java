package access.one;

class C { // Package-private class (default access)

    // Package private method - only for package friends (default access)
    void packagePrivateMethodC() {
        System.out.println("Package-private method in B");
    }

}
