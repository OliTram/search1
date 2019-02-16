package es.upm.gib.eutilsrdfwrapper.examples;

import es.upm.gib.eutilsrdfwrapper.Controller;

/**
 * Example 1
 */
public class Example1 {

    public static void main(String args[]) {

        // the query to launch
        // this query asks for publications in PubMed with the general search term "dietary probiotics", and extracts the UID, title and journal
        // from the retrieved publications. No limit is specified, so a maximum of 100 results are retrieved
        String query = "PREFIX eurdf: <http://RDFEutilsWrapper#>\n" +
                "SELECT ?p1_uid ?p1_titl ?p1_jour\n" +
                "WHERE {\n" +
                "    ?p1 a                 eurdf:pubmed.\n" +
                "    ?p1 eurdf:pubmed_ALL  ?p1_all.\n" +
                "    ?p1 eurdf:pubmed_UID  ?p1_uid.\n" +
                "    ?p1 eurdf:pubmed_TITL ?p1_titl.\n" +
                "    ?p1 eurdf:pubmed_JOUR ?p1_jour.\n" +
                "\n" +
                "    FILTER (?p1_all = \"\\\"dietary probiotics\\\"\").\n" +
                "}";

        // NCBI2RDF is invoked
        String resultPath = Controller.launchQueryGetPath(query);

        // The results are generated in a file located in .\EutilsWrapper\Results\results_"currentdate".xml
        System.out.println("Results are in " + resultPath);
    }
}

//http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=pubmed&term=%22dietary+probiotics+%22&usehistory=y&retmax=200
//http://eutils.ncbi.nlm.nih.gov/entrez/eutils/esearch.fcgi?db=pubmed&term=%22%22dietary+probiotics+%22%22&usehistory=y&retmax=200
