
    public static void main(String[] args) throws IOException {
        SpotDevelopDB api = new SpotDevelopDB();
        System.out.println(api.getAuthorizationToken("AQBFvYvoO3abMJA5qSHB4zhqigaktLkKP4_duKVqSsINbw4RIC7AFgYEjpjV8ZStswR3paWK5a9jQV-3o8dWxLB-f2AgsoCDeRO1PUGpLl42J7jwhrbXpKO3tPeUVxUHIje4aXOwuRSLGTnWWCfrg0eZ9M5tsi2mKanJgL5N1nzJCaIDUgz_CuwaqU2zr61BwqjBh-xdaoxQDmujACR-2kzIGMyULEsTPO4J6LCPnm0EsD3TgADCh4v0JftDs5ErQxivt44eTXYsSDXXFhghGaUYAAI66u3Hokwgcqg3wJCHvyQIe8ejg8S1q7mUqmM4iaU"));
    }

    @org.junit.Test
    public void testTopSongs() throws Exception {
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();

        Song[] topSongs = userDataAccessObject.getTopSongs("0wn1qh223kptm533gbxyin4mh", "long_term");
        assert(Objects.equals(topSongs[0].getName(), "Living with a Stranger"));
    }

