package access.app;

import api.ApiBase;

// This class extends api.ApiBase and is in a different package
// It can successfully call protectedMethodAPI() within its own methods because it's a subclass.
public class ExtendedAPI extends ApiBase { // extends the ApiBase class from another package

    public void callProtectedMethod() {
        protectedMethodAPI(); // ✅ Protected method of parent - inherited
                              // can be accessed directly as if it was declared in ExtendedAPI itself.
    }
}
