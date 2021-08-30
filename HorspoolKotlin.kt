fun main() {

    val list: ArrayList<String> = ArrayList()
    list.add("Ronaldo")
    list.add("Ronaldinho")
    list.add("Rivaldo")
    list.add("M. Owen")
    list.add("E. Cavani")
    list.add("Bernardo Silva")
    list.add("David Silva")
    list.add("Gilberto Silva")
    list.add("Wan Bissaka")

    print("Cari pemain :")
    var pattern = readLine()

    for(i in 0..list.size - 1){
        val source = list.get(i)
        val searched = boyerMooreHorspoolSearch(source, pattern)
        println(searched)
    }

    /////////////////////////////////////////////////////////////////////////////
// val source = "Ronaldo"
// val pattern = "aldo"
// val returnValue = boyerMooreHorspoolSearch(source, pattern)

// print(returnValue)
 
}


// source : ronaldo
// pattern : do
fun boyerMooreHorspoolSearch(source: String, pattern: String?): Int {
    val pattChar = pattern?.toCharArray() //[a,l,d,o]
    val patternLength: Int = pattChar!!.size // 4

    if (patternLength == 0) {
        return 0
    }

    val src = source.toCharArray() // [r,o,n,a,l,d,o]
    val srcLength: Int = src.size // 7

    var shift = IntArray(255) { patternLength } // [7, ,... ,..., ..., ...]

    for (k in 0..(patternLength - 2)) { // 3 kali looping --> 4 - 2 = 2
        // rumus value : len - 1 - index
        shift[pattChar[k].toInt()] = patternLength - 1 - k
        //print("${pattChar[k].toInt()}-")

        // menggunakan kode ascii sebagai index untuk menyimpan value 
        // maka a,l,d,o
        /*
        letter | ASCII AS INDEX | VALUE 
        a      | shift[97]      | 3
        l      | shift[108]     | 2
        d      | shift[100]     | 1
        o      | shift[111]     | 4
        *      | none           | 4
        */
    }

    // kasus text=Ronaldinho
    var i = 0
    var j: Int
    while ((i + patternLength) <= srcLength) { // 4<=10|| 7 <= 10
        j = patternLength - 1 // j=3|| j=3

        while (source[i + j] == pattChar[j]) { // source[3] == pattchar[3] a == o NOT || source[6] == pattChar[3]
            j -= 1 // 
            if (j < 0) {
                return i
            }
        }

        i += shift[src[i + patternLength - 1].toInt()] // shift[src[3].toint] -> shift[97] || shift[src[6]] -> shift[105] = 4 karena selain di pattern (*) pergeserannya adalah len dari pattern
        //print("ini i : $i")

        /*i = 3; i = 7 */
    }
    return 404
}

// catatan penting
/*
   - value untuk char yang tidak ditemukan di pattern = len dari pattern
   - size shift 255 merupakan wakil dari 255 kode yang ada di ascii
*/

