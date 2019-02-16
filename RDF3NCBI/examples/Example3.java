package es.upm.gib.eutilsrdfwrapper.examples;

import es.upm.gib.eutilsrdfwrapper.Controller;

/**
 * Example 3
 */
public class Example3 {

    public static void main(String args[]) {

        // the query to launch
        // this query retrieves publications from pubmed in which title can be found "wilms tumor". For these publications, related genes from the
        // gene database are extracted, and finally, related publications for each of these genes are retrieved again from pubmed
        // A limit of 50 results is specified
        String query = "PREFIX eurdf: <http://RDFEutilsWrapper#>\n" +
                "SELECT ?pubmed_uid ?pubmed_title ?gene_uid ?pubmed2_uid ?pubmed2_title ?pubmed2_journal\n" +
                "WHERE {\n" +
                "    ?pubmed  a                 eurdf:pubmed.\n" +
                "    ?gene    a                 eurdf:gene.\n" +
                "    ?pubmed2 a                 eurdf:pubmed.\n" +
                "    ?pubmed  eurdf:pubmed_UID  ?pubmed_uid.\n" +
                "    ?pubmed  eurdf:pubmed_TITL ?pubmed_title.\n" +
                "    ?pubmed  eurdf:pubmed_AUTH ?pubmed_auth.\n" +
                "    ?pubmed  eurdf:pubmed_gene ?gene.\n" +
                "    ?gene    eurdf:gene_UID    ?gene_uid.\n" +
                "    ?gene    eurdf:gene_pubmed ?pubmed2.\n" +
                "    ?pubmed2 eurdf:pubmed_UID  ?pubmed2_uid.\n" +
                "    ?pubmed2 eurdf:pubmed_TITL ?pubmed2_title.\n" +
                "    ?pubmed2 eurdf:pubmed_JOUR ?pubmed2_journal.\n" +
                "\n" +
                "    FILTER (?pubmed_auth = \"russ altman\").\n" +
                "}\n" +
                "LIMIT 50";

        // NCBI2RDF is invoked
        String resultPath = Controller.launchQueryGetPath(query);

        // The results are generated in a file located in .\EutilsWrapper\Results\results_"currentdate".xml
        System.out.println("Results are in " + resultPath);
    }
}
