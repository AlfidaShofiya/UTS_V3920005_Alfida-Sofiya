// untuk mengilustrasikan class Affine Cipher
 
class GFG
{
 
    // Nilai kunci A dan B
    static int a = 9;
    static int b = 11;
 
    static String encryptMessage(char[] msg)
    {
        /// Teks cipter awalnya kosong
        String cipher = "";
        for (int i = 0; i < msg.length; i++)
        {
            // Menerapkan rumus enskripsi (ax + b) mod 26
            if (msg[i] != ' ')
            {
                cipher = cipher
                        + (char) ((((a * (msg[i] - 'A')) + b) % 26) + 'A');
            } else // else cukup tambahkan karakter spasi
            {
                cipher += msg[i];
            }
        }
        return cipher;
    }
 
    static String decryptCipher(String cipher)
    {
        String msg = "";
        int a_inv = 0;
        int flag = 0;
 
        for (int i = 0; i < 26; i++)
        {
            flag = (a * i) % 26;
 
            // menjadikan invers perkalian dari a
            if (flag == 1)
            {
                a_inv = i;
            }
        }
        for (int i = 0; i < cipher.length(); i++)
        {
            
            if (cipher.charAt(i) != ' ')
            {
                msg = msg + (char) (((a_inv *
                        ((cipher.charAt(i) + 'A' - b)) % 26)) + 'A');
            }
            else // cukup tambahkan karakter spasi
            {
                msg += cipher.charAt(i);
            }
        }
 
        return msg;
    }
 
    public static void main(String[] args)
    {
        String msg = "SUCCESS IS NOT FINAL FAILURE IS NOT FATAL IT IS THE COURAGE TO CONTINUE THAT COUNTS";
 
        // Memanggil fungsi enkripsi
        String cipherText = encryptMessage(msg.toCharArray());
        System.out.println("Encrypted Message is : " + cipherText);
 
        // Memanggil fungsi Deskripsi
        System.out.println("Decrypted Message is: " + decryptCipher(cipherText));
 
    }
}