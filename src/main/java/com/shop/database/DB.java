package com.shop.database;

import com.shop.models.Post;
import com.shop.models.User;

import java.util.ArrayList;
import java.util.List;

public class DB {
    public static final List<Post> posts;
    public static final List<User> users;

    static {
        posts = new ArrayList<>();
        posts.add(new Post("bmw", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSssUroA7-HTwF-OAuhLbzc4a5AUJC9wbkU6DMlkXDFQg&s=36"));
        posts.add(new Post("mercedes", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwBnurdc-10G9Rk1tDGBHJ-HBvC2Ci385UEAKJ_tEqYQ&s=36"));
        posts.add(new Post("audi", "data:image/webp;base64,UklGRvgHAABXRUJQVlA4IOwHAAAQJgCdASqkAHsAPpFInUulpCK0pNTpSpASCWc69++OYH4SIKJLGOcb5hT+jwflv562E7ir0tc1DyqfW7EeGoeGtED8+cVv+lp5hq/75L4Gkh/2/8/v0zPQV1nxelbUoKousFT85DZ7wZFAuUqS3fWGZ0/SpyS7EOZLWmNXibVgNEMI+BhTu/t3AX0xdaettDkNAuSTqim9vtmAY+POgn9O4cT/E4i4ooRGrRn2EUbdVzrXwIXrYtjtkIXu/NjeXgbjdsrAiAh7QZcMe4VWwUC73aoSRHUFPkNSZ9/IGBO4t2o4ns1NmJADdenBWFxagjCBEk1EvUtvRP/UKPav+L0bYxOAwZLKW3V+BUHPcBqpSaGDMGqDt0pdNypCdMS72/KtxS83WVLSHLhYl5MS52ImNV3krjSEP0hAAP7xZrc8+fy2gjRaazCHotU0MNtMmCHrp4ledlm37zX5YOMlW/cetIampntFcs5r90yUpQGMtsJRTU/muwD1HyLIdzMZnYRrFwmEDCan2I3Z3wRrunzkiOXyDyfmeE+L10olR1Fe9H4HCeBvP0HnOydMzdyhysofAegZ+3oeKA9AH9G6IKEeMSzZppyqyY95nQn5N7fpBTZPaQ6tz1DTVvfAo4YO8ntJMrYgxt1zqkvLfmSwbiJNiAVR6e+33GmL4Lau30pKc2ty4eeMzgRHSFm4mlATO+AyNmxsMP0gP5D+OT3krfP85IIOTHpfG4baeWFiIQ14RYXeb69h9eigailjzeyk46N8vIsM/zPl5hRIkinrDfmkeve9u+6jXUooaj4JY3Pspzbq48xkn0SZ6oCyFwymZQaHfpgu6HcbW/ILAtrSN+QL7xP0fscH6fUloj5BICWKp88XzK0D20aWAvrRsYBSfiiX86157Bv3g54SRskWyIUGJJY+yX3prfKXfbVFIMmHyutwvTzrhvVUX4jHTMkznjc6h+pEBfgTekRABnBe5B1/Z5YZFqch7h7Lan3r1bF4ZOh/ueUU2OXl6poAkuHvo8qYsMSomel3a9mUGueaed6iKRK9rOyK3MLhQgleeeOp312yMwWeqsrZjK22ON4e+mywXCC57bSRMTHx2RGCaLgP+8YPT3UM284pah2YYulkroYiP76J5ij16wrqv2x62B+mqpJDny3PSXoiVPnqb41MghjiDypdgAlIc8R7ithBCa0EyPDyClbwr5s3oTOlhiqG00tJS688Wo08iI6dH3VgICMIbsrYy0QNLP4icP8OBDXX1EGQArZPkIqYfdFkt0EEqjD92Fx7HY/MVNDd/aiidnlxrnhm6nVXJgMSaHk0qDRh8B37dL67wBlNlDmrP9oCcVII36XVBmbwnTnY0m4jXyR5fGIJlZViBWx2B5JbDK+IjO6TbFrgNtfaibws4BpCgYXXoEjFJspI5kxew9xGckX9lVdXP6Ad3t0vf17KMbxL5d6ZXUb2xRU0y/bYmYWDxhX+/FZLlqhn1aFSmAGCm3kK3BmzO4riHux0nkT8qplKz0r7CdEVPlaeWrl3sWLuEVVjxPrHvjLfnrzs/A0cZv7B7eoLmdAnO7nnYYvensTvxwlceci51XKUxmbbbac3ImTjNMQintShm3JJQVJlbLNKz3k7ICsN60IW/7tghkD/KcL90OWnOAnK3x7D8CAm/4fWABbfcS7zpIjKL77fjXTWCAVkCE4drayBcdiUS7ZwCtr01o9ax2j6y2wjnRWul1b+ts3kRFQrbUO1YbitW6ovkZtQ7vSIK/t33nWCo6WkHW5xN/Nz2q+rjoMjtkZDjcEi+HDdXVmfrldr5R0boenKzm9Au3qijilafmpLk10bnCYDdWyFdQCXOjW20yW59d772+XSomejahg9mb3kKAQz+nHvaC1YspOneRW2t+O2IscgjfkxbXhd4fQ3yPprvIJCLewZ5iRD28TSUVCxHhpwaVLd8Sr7ZGRnSxn1QfBAihrg1Mh2nb/u7IvPDaX+QVtm84Bu8qYJpnnLBglz21XJJUojMb5uE+k5Uofb3UXHazTdeMbBuQ3RDh08QYSae8sNqRoWniZY4YP2azf9SVhEkV7vKdNA3pacRAYxbCAB6tzbVFdSUrQ1ONuQ+B7uhDrSXyjLyMmk1GI3JrFkqmhxJ2+iCFL1FaQUagK4W/8ylulaPzbVBUWJ2RKrsn/CQWVCJvExNHMb2B4Bo9qUy37K8qw8z72WDQzPi+0imbDY+gW8y/eof6zArWA9NCoav4IF/x1c8MImmv54F7ZFcp6YOdlTV5ocrzLPZSJt/l9A3fvnuhOJW/NuhITdmiaKnS1Kp2N2/eQSMsvbuOaIBtDU3b0E5y3n+VSChnfX7hHuvSUC1tYxWjhGygSMjVXTDr5eYn4c1YF2n17tIQq2Htz0Yze+JMnBqPPt3r1tQKSwI9js9xWKvgZWHIeHU3i4y/Y9BKHnpT/fkQapPcak6nuuoQiKUlCOBWTO2ikI7eqnkkm0ShASBvyF5gDjmv7ZkIGE5+NT90VDgspPTb4Eh/0bMHClMF+rMI5gIfKt3DL4bjlEeY9D+8ulFAQzy46198C2AFmO2BFhMxwCTbOQX2tlNwrA0mVd1TTAFmuKruOAs+D6EjJ/eY0NC4KJcZ93LQY7uO3jbb8YiZFV3waOd0EvHZL2sTKR5NTh/HKJjQYo5BmVrv0KODoYTpAEacuShiSFNM9N3gAAAAA="));
        users = new ArrayList<>();
    }

    public static boolean containsUserWithUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsUserWithEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public static User getByUsernameAndPassword(String username, String password) {
        User user = new User(username, password);
        for (User u: users) {
            if (u.equalsByUsernameAndPassword(user)) {
                return u;
            }
        }
        return null;
    }
}
