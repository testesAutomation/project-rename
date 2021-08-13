package config;

public enum Headers {

    AUTHORIZATION ("Authorization"),
    BEARER ("Bearer "),
    INVALIDTOKEN ("123erro"),
    EXPIREDTOKEN ("eyJhbGciOiJSUzUxMiJ9.eyJqdGkiOiIxMjZiNjJiZS0wMDJmLTQxNWYtYmEyZC1iZjYxOTEwZjAwZDMiLCJpYXQiOjE2MjYyODI4NDcsInNjb3BlIjpbIlJFQUQiLCJTTUU2MTMxfGdycC1zYW5kYm94LWRleHRyYSJdLCJjbGllbnRfaWQiOiI2MDQ5MDQ1ZmRjODFjYzNhY2FmOGY2MDMiLCJhcHBfaWQiOiI1ZmMxNGNhMGRjZjNlNzcyNDNhZmUwMjEiLCJidXNpbmVzc19pZCI6IjEyMyIsInNlcnZpY2VfaWQiOiI2MDQ5MDQ1ZmJkOGFiMzQ5MDMwNWFiMzIiLCJhdXRob3JpdGllcyI6WyJST0xFX0NMSS1BVVRILUJBU0lDIiwiUk9MRV9DTEktQVVUSC1JREVOVElGSUVEIiwiUk9MRV9DTEktMVNUUEFSVFkiLCJST0xFX0NMSS0zUkRQQVJUWSJdLCJleHAiOjE2MjYyODY0NDd9.fWdFGqLEpwvqVhznehwAjjFItQvZXrh__Co4YdGdb4eNC3YzgJ4Whgx2CZwVvhBaKhKGLfPPDqJ1yoL38A0sPdvlrIuOWWgpQu9prPqz2gyT5Xa1w_EB5yFAlKMcBvEJeIiDqeqm6nl8C6EjdxFzzmDhxaDRFbK9KFHSxQskEHMVHdTuJ-l4UC_AAN2vYxEADhKgUh2tTcqvCWidIsbcpE18XlDhgzjc_PMqbGWm70Sl0yKDlgF1XYViPv8GF-fVoFMGS2-kRISihPNGfIvRnTzQEz-XacFqDbFTl-G-q9kzzLr-xYvy_sycg53gFIQtikveHUmw7EvM0496wUQQZQ");

    private String header;

    Headers(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    @Override
    public String toString() {
        return header;

    }
}
