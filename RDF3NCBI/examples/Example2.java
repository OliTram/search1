package es.upm.gib.eutilsrdfwrapper.examples;

import es.upm.gib.eutilsrdfwrapper.Controller;

/**
 * Example 2
 */
public class Example2 {

    public static void main(String args[]) {

        // the query to launch
        // this query retrieves publications in which "russ altman" in one of the authors, and the publications have related entries in the gene 
        // database. In each case, the publication uid and title, and the gene uid are retrieved
        // the limit of retrieved results is set to 20
        String query = "PREFIX eurdf: <http://RDFEutilsWrapper#>\n" +
                "SELECT ?pubmed_uid ?pubmed_title ?gene_uid\n" +
                "WHERE {\n" +
                "    ?pubmed a                 eurdf:pubmed.\n" +
                "    ?gene   a                 eurdf:gene.\n" +
                "    ?pubmed eurdf:pubmed_UID  ?pubmed_uid.\n" +
                "    ?pubmed eurdf:pubmed_TITL ?pubmed_title.\n" +
                "    ?pubmed eurdf:pubmed_AUTH ?pubmed_auth.\n" +
                "    ?pubmed eurdf:pubmed_gene ?gene.\n" +
                "    ?gene    eurdf:gene_UID   ?gene_uid.\n" +
                "\n" +
                "    FILTER (?pubmed_auth = \"russ altman\").\n" +
                "}\n" +
                "LIMIT 20";

        // NCBI2RDF is invoked
        String resultPath = Controller.launchQueryGetPath(query);

        // The results are generated in a file located in .\EutilsWrapper\Results\results_"currentdate".xml
        System.out.println("Results are in " + resultPath);
    }
}
