/**
 * @author Anirudh Sharna
 */
function find_indices(s, p) {
    // Set of indices
    let result = [];
    // Build a hash of the letters.
    let wordHash = {}; // Master copy.
    let hash = {}; // Current copy.
    p.split('').forEach(function (letter) {
        wordHash[letter] = wordHash[letter] ? wordHash[letter] + 1 : 1;
        hash[letter] = hash[letter] ? hash[letter] + 1 : 1;
    });

    let count = 0;
    let index = -1;

    for (let i = 0; i < s.length; i++) {
        let letter = s[i];
        if (hash[letter]) {
            // Part or start of an anagram.
            if (index === -1) {
                index = i;
            }
            hash[letter]--;
            count++;
            if (count === p.length) {
                // Completed an anagram.
                result.push(index);

                // Reset variables.
                hash[s[index]]++;

                count = p.length - 1;
                index++;
            }
        }
        else {
            // Reset variables.
            if (index !== -1 && hash[letter] !== undefined && (p.length <= s.length - index)) {
                // Find first occurrence of 'letter'. Set the starting point 'index' to next letter.
                for (var j = index; j < i; j++) {
                    index++;
                    if (s[j] === letter) {
                        break;
                    }
                    else {
                        hash[s[j]]++;
                        count--;
                    }
                }
            }
            else {
                // Restore hash and counter.
                let keys = Object.keys(hash);
                for (let j = 0; j < keys.length; j++) {
                    hash[keys[j]] = wordHash[keys[j]];
                }
                count = 0;
                index = -1;
            }
        }
    }
    return result;
}


let text = "BACDGABCDA";
let pattern = "ABCD";
console.log("Anagrams found at: " + find_indices(text, pattern));

text = "XYYZXZYZXXYZ";
pattern = "XYZ";
console.log("Anagrams found at: " + find_indices(text, pattern));