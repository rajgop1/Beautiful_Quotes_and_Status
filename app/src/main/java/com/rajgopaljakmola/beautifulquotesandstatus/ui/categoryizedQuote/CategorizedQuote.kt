package com.rajgopaljakmola.beautifulquotesandstatus.ui.categoryizedQuote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.rajgopaljakmola.beautifulquotesandstatus.R
import com.rajgopaljakmola.beautifulquotesandstatus.adapter.RvCategorizedQuoteAdapter
import com.rajgopaljakmola.beautifulquotesandstatus.adapter.RvQuoteHomeAdapter
import com.rajgopaljakmola.beautifulquotesandstatus.databinding.ActivityCategorizedQuoteBinding
import com.rajgopaljakmola.beautifulquotesandstatus.databinding.ActivityMainBinding
import com.rajgopaljakmola.beautifulquotesandstatus.model.RvCategorizedQuoteModel
import com.rajgopaljakmola.beautifulquotesandstatus.model.RvQuoteHomeModel

class CategorizedQuote : AppCompatActivity() {
    private lateinit var dataList:ArrayList<RvCategorizedQuoteModel>
    private lateinit var rvAdapter: RvCategorizedQuoteAdapter
    private lateinit var binding: ActivityCategorizedQuoteBinding

    lateinit var mAdView : AdView
    private var mInterstitialAd: InterstitialAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategorizedQuoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val category = intent.getStringExtra("category")

        dataList = ArrayList<RvCategorizedQuoteModel>()

        when (category) {
            "Birthday" -> {
                Toast.makeText(this, "Birthday", Toast.LENGTH_SHORT).show()
                dataList.add(RvCategorizedQuoteModel("Count your life by smiles, not tears. Count your age by friends, not years.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Today you are you! That is truer than true! There is no one alive who is you-er than you!", "Dr. Seuss"));
                dataList.add(RvCategorizedQuoteModel("Birthdays are a new start, a fresh beginning, and a time to pursue new endeavors with new goals. Move forward with confidence and courage. You are a special person, and may you have an amazing birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Age is an issue of mind over matter. If you don't mind, it doesn't matter.", "Mark Twain"));
                dataList.add(RvCategorizedQuoteModel("Happy birthday! May your special day be filled with love, laughter, and all the things you cherish in life.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("You are never too old to set another goal or to dream a new dream.", "C.S. Lewis"));
                dataList.add(RvCategorizedQuoteModel("A birthday is not only a time to celebrate but also a time to reflect on the precious moments and memories that have brought you to this point in your life.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("May your birthday be filled with sunshine, smiles, laughter, and love. Happy birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Don't count the years, make the years count.", "George Meredith"));
                dataList.add(RvCategorizedQuoteModel("It's your birthday! Celebrate, indulge, and enjoy this special day to the fullest. You deserve it!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Age is just a number. What really matters is how you feel inside. Happy birthday, and may your heart always stay young and joyful!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Wishing you a birthday filled with love, happiness, and all the things you enjoy most in life.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Another year older, another year wiser. Embrace the wisdom that comes with age and live your life to the fullest.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy birthday! May this day bring you joy, laughter, and an abundance of blessings as you embark on another wonderful year of life.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Age is not important unless you're a cheese.", "Billie Burke"));
                dataList.add(RvCategorizedQuoteModel("On your birthday, I wish you abundant happiness and love. May all your dreams and wishes come true. Happy birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Birthdays are a reminder to cherish each moment of your life, as you have touched the lives of others in beautiful ways. Happy birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Live your life and forget your age. Happy birthday!", "Norman Vincent Peale"));
                dataList.add(RvCategorizedQuoteModel("Sending you warmest wishes on your birthday. May this year be filled with endless opportunities, joy, and success.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Birthdays are not just about growing older but also about growing wiser and appreciating the beautiful journey of life. Happy birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy birthday! May your special day be filled with joy, love, and unforgettable moments.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Wishing you a birthday that's as amazing and extraordinary as you are. Have a fantastic day!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Today is a perfect day to celebrate the wonderful person you are. Happy birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("May your birthday be the start of a year filled with bright opportunities and great achievements. Enjoy your special day!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Sending you heartfelt wishes for an incredible birthday celebration. May all your dreams come true!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy birthday! May your heart be filled with happiness, your mind with positivity, and your life with success.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("On your birthday, may you be surrounded by laughter, love, and the company of those who cherish you. Have a wonderful day!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("As you blow out the candles on your cake, may each one represent a wish come true. Happy birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Wishing you a birthday that's as sweet as you are. Enjoy every moment and make beautiful memories!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy birthday! May your day be filled with sunshine, smiles, and the love of your dear ones.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Today, we celebrate the gift of your life and the joy you bring to the world. Happy birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("May your birthday be a magical day filled with love, surprises, and beautiful moments to treasure forever.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy birthday! May this year be your best one yet, filled with endless possibilities and delightful adventures.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Wishing you a day filled with laughter, good times, and the company of your loved ones. Have a fantastic birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Today, we celebrate the incredible person you are and all the happiness you bring into our lives. Happy birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("May your birthday be the beginning of a new chapter filled with love, peace, and fulfillment. Enjoy your special day!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Sending you warmest wishes on your birthday. May this year be your best one yet, full of blessings and exciting opportunities.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy birthday! May your heart be filled with gratitude, your spirit with joy, and your life with endless possibilities.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Wishing you a birthday filled with beautiful moments, cherished memories, and dreams that become reality. Enjoy your day!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("May your birthday be the start of a wonderful journey that leads to an even more amazing future. Happy birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy birthday to someone who brightens every day with their smile. May your special day be filled with happiness and laughter.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("On your birthday, I wish you love, joy, and all the little things that make life beautiful. Have a wonderful day!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Wishing you a birthday filled with sweet moments, delightful surprises, and cherished memories. Happy birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("May your birthday be a reflection of the love and happiness you bring into the lives of others. Enjoy your special day!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy birthday! May this year be full of exciting adventures, wonderful opportunities, and success in all your endeavors.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Sending you warmest wishes on your birthday. May this new chapter of your life be filled with joy, love, and fulfillment.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Wishing you a birthday that's as beautiful and extraordinary as you are. Celebrate and enjoy every moment!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy birthday! May the coming year bring you countless blessings, abundant happiness, and endless possibilities.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("On your special day, I want to remind you of how amazing you are and how much you mean to those around you. Happy birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("May your birthday be the beginning of a new chapter filled with love, peace, and fulfillment. Enjoy your special day!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy birthday! May this year be your best one yet, filled with joy, laughter, and unforgettable moments.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Wishing you a day filled with love, laughter, and the company of your loved ones. Have a fantastic birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Today, we celebrate the wonderful person you are and the joy you bring to our lives. Happy birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("May your birthday be as incredible as you are, and may your heart be filled with happiness and contentment. Enjoy your day!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy birthday! May this special day bring you countless blessings, abundant love, and happiness beyond measure.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Wishing you a birthday filled with sunshine, laughter, and the company of those who bring out the best in you. Have a wonderful day!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("On your birthday, may you be surrounded by love, surrounded by joy, and surrounded by the people who mean the most to you. Happy birthday!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("May this birthday be the beginning of a year filled with love, laughter, and beautiful memories. Celebrate and enjoy every moment!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy birthday! May your day be as incredible and wonderful as you are. Here's to another year of blessings and opportunities!", "Unknown"));

            }
            "Anniversary" -> {
                Toast.makeText(this, "Anniversary", Toast.LENGTH_SHORT).show()
                dataList.add(RvCategorizedQuoteModel("The secret to a happy marriage is finding someone you can go through the storms of life with.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("A successful marriage requires falling in love many times, always with the same person.", "Mignon McLaughlin"));
                dataList.add(RvCategorizedQuoteModel("The best thing to hold onto in life is each other.", "Audrey Hepburn"));
                dataList.add(RvCategorizedQuoteModel("Love is not about how many days, months, or years you have been together. It's about how much you love each other every single day.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("In all the world, there is no heart for me like yours. In all the world, there is no love for you like mine.", "Maya Angelou"));
                dataList.add(RvCategorizedQuoteModel("True love stories never have endings.", "Richard Bach"));
                dataList.add(RvCategorizedQuoteModel("Marriage is the golden ring in a chain whose beginning is a glance and whose ending is eternity.", "Kahlil Gibran"));
                dataList.add(RvCategorizedQuoteModel("A successful marriage is built on love, trust, and laughter.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("The greatest happiness of life is the conviction that we are loved; loved for ourselves, or rather, loved in spite of ourselves.", "Victor Hugo"));
                dataList.add(RvCategorizedQuoteModel("Love is not about possession. It's all about appreciation.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Two souls with but a single thought, two hearts that beat as one.", "John Keats"));
                dataList.add(RvCategorizedQuoteModel("A strong marriage requires two people who choose to love each other even on the days when they struggle to like each other.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Love is the greatest refreshment in life.", "Pablo Picasso"));
                dataList.add(RvCategorizedQuoteModel("A great marriage is not when the 'perfect couple' comes together. It is when an imperfect couple learns to enjoy their differences.", "Dave Meurer"));
                dataList.add(RvCategorizedQuoteModel("Love is the master key that opens the gates of happiness.", "Oliver Wendell Holmes"));
                dataList.add(RvCategorizedQuoteModel("The most precious gift you can give one another is the gift of your time and attention.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("The best love is the kind that awakens the soul; that makes us reach for more, that plants the fire in our hearts and brings peace to our minds.", "Nicholas Sparks"));
                dataList.add(RvCategorizedQuoteModel("A successful marriage requires falling in love many times, always with the same person.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Grow old with me, the best is yet to be.", "Robert Browning"));
                dataList.add(RvCategorizedQuoteModel("Love is not about finding the perfect person, but about seeing an imperfect person perfectly.", "Sam Keen"));
                dataList.add(RvCategorizedQuoteModel("Cheers to another year of love, laughter, and beautiful memories. Happy anniversary!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("On this special day, we celebrate the love and commitment that have kept us together. Happy anniversary!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Wishing a happy anniversary to the most amazing couple. May your love continue to grow and strengthen with each passing year.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("May the love you share today be as beautiful as the day you first said 'I do'. Happy anniversary!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy anniversary to a couple who inspires us with their unwavering love and devotion. Here's to many more years of togetherness!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("As you celebrate another year of marriage, may your hearts be filled with gratitude, joy, and boundless love. Happy anniversary!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("On your anniversary, may you look back on all the wonderful moments you've shared and look forward to creating even more beautiful memories together. Congratulations!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy anniversary! May the love you share continue to blossom and bring you happiness and fulfillment in the years ahead.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Sending you warm wishes on your anniversary. May your love story always be filled with passion, understanding, and endless romance.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Cheers to the incredible journey of love and companionship you both have embarked upon. Happy anniversary!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Congratulations on another year of love, laughter, and wonderful memories. Wishing you a fantastic anniversary!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy anniversary to a couple who exemplifies true love and commitment. May your bond continue to grow stronger with each passing year.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("On this special day, we celebrate the beautiful union of two amazing souls. Happy anniversary!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("May your anniversary be a time to cherish the moments you've shared and look forward to the wonderful times ahead. Happy anniversary!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy anniversary to a couple who continues to inspire us with their love and dedication. May you be blessed with many more years of happiness together.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Wishing you a joyous anniversary filled with love, laughter, and cherished memories. Congratulations!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy anniversary to a couple who defines the meaning of true love. May your hearts always beat as one. Cheers!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Congratulations on reaching another milestone in your journey of love. May your anniversary be filled with sweet moments and heartfelt blessings.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("On your anniversary, may you continue to write a beautiful love story that inspires others. Happy anniversary!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Wishing a happy anniversary to a couple who truly deserves all the love and happiness in the world. Celebrate and cherish each other!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy anniversary to a couple who still looks at each other with love and admiration after all these years. May your bond continue to grow stronger. Congratulations!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Cheers to the love that withstands the test of time. Happy anniversary to a couple who inspires us with their commitment and devotion.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("On this special day, we celebrate the beautiful love story you both have created. May your anniversary be filled with joy and precious moments.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Wishing a happy anniversary to a couple who fills our lives with love and happiness. May your journey of togetherness be filled with countless blessings.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Congratulations on another year of love, laughter, and companionship. May your anniversary be the start of a new chapter filled with even more love and happiness.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy anniversary to a couple who shows us what true love is all about. May your hearts always be united and your love continue to flourish.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("On your anniversary, may you be reminded of all the reasons you fell in love and said 'I do'. Happy anniversary!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Wishing you a beautiful anniversary filled with warmth, romance, and cherished memories. Congratulations on another year of love and happiness.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy anniversary! May the love you share continue to shine brightly and inspire others. Here's to many more years of blissful togetherness.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("May your anniversary be a time to reflect on the incredible journey you've taken together and the love that has grown between you. Happy anniversary!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Congratulations on reaching another milestone in your love story. May your anniversary be filled with joy, laughter, and the sweetest moments.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy anniversary to a couple who knows that true love only gets stronger with time. May your hearts always beat as one.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("On your anniversary, may you be blessed with everlasting love, unwavering commitment, and a lifetime of happiness. Celebrate and cherish each other!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Wishing a happy anniversary to a couple who continues to inspire us with their love and dedication. May your bond continue to grow stronger with each passing year.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Congratulations on another year of love, companionship, and beautiful memories. May your anniversary be a celebration of your incredible journey together.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy anniversary to a couple who defines the meaning of love, respect, and partnership. May your love continue to flourish and bring you endless joy.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("On this special day, we honor the love and commitment that have kept you together. Wishing you a happy anniversary filled with love and happiness.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("May your anniversary be a reminder of all the reasons you fell in love and a celebration of the beautiful life you've built together. Happy anniversary!", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happy anniversary to a couple who proves that soulmates are real. May your love continue to inspire and touch the hearts of those around you.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("On your anniversary, may you be surrounded by love, joy, and the warmest wishes. Cheers to the love that grows stronger with each passing year.", "Unknown"));


            }
            "Love" -> {
                Toast.makeText(this, "Love", Toast.LENGTH_SHORT).show()
                dataList.add(RvCategorizedQuoteModel("Love is not about how many days, months, or years you have been together. It's about how much you love each other every single day.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("The best and most beautiful things in this world cannot be seen or even heard, but must be felt with the heart.", "Helen Keller"));
                dataList.add(RvCategorizedQuoteModel("Love is composed of a single soul inhabiting two bodies.", "Aristotle"));
                dataList.add(RvCategorizedQuoteModel("Love is when the other person's happiness is more important than your own.", "H. Jackson Brown Jr."));
                dataList.add(RvCategorizedQuoteModel("You know you're in love when you can't fall asleep because reality is finally better than your dreams.", "Dr. Seuss"));
                dataList.add(RvCategorizedQuoteModel("Love isn't something you find. Love is something that finds you.", "Loretta Young"));
                dataList.add(RvCategorizedQuoteModel("Love is the greatest refreshment in life.", "Pablo Picasso"));
                dataList.add(RvCategorizedQuoteModel("To love and be loved is to feel the sun from both sides.", "David Viscott"));
                dataList.add(RvCategorizedQuoteModel("The best love is the kind that awakens the soul; that makes us reach for more, that plants the fire in our hearts and brings peace to our minds.", "Nicholas Sparks"));
                dataList.add(RvCategorizedQuoteModel("Love is not about possession. It's all about appreciation.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Being deeply loved by someone gives you strength while loving someone deeply gives you courage.", "Lao Tzu"));
                dataList.add(RvCategorizedQuoteModel("Love is like the wind, you can't see it but you can feel it.", "Nicholas Sparks"));
                dataList.add(RvCategorizedQuoteModel("Love is when you meet someone who tells you something new about yourself.", "Andre Breton"));
                dataList.add(RvCategorizedQuoteModel("Love is not finding someone to live with; it's finding someone you can't live without.", "Rafael Ortiz"));
                dataList.add(RvCategorizedQuoteModel("Love recognizes no barriers. It jumps hurdles, leaps fences, penetrates walls to arrive at its destination full of hope.", "Maya Angelou"));
                dataList.add(RvCategorizedQuoteModel("Love is the bridge between two hearts.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("In the arithmetic of love, one plus one equals everything and two minus one equals nothing.", "Mignon McLaughlin"));
                dataList.add(RvCategorizedQuoteModel("Love is like a friendship caught on fire. In the beginning, a flame, very pretty, often hot and fierce, but still only light and flickering. As love grows older, our hearts mature and our love becomes as coals, deep-burning and unquenchable.", "Bruce Lee"));
                dataList.add(RvCategorizedQuoteModel("Love is an irresistible desire to be irresistibly desired.", "Robert Frost"));
                dataList.add(RvCategorizedQuoteModel("Love is not about who you live with. It's about who you can't live without.", "Unknown"));

            }
            "Motivational" -> {
                Toast.makeText(this, "Motivational", Toast.LENGTH_SHORT).show()
                dataList.add(RvCategorizedQuoteModel("Believe you can and you're halfway there.", "Theodore Roosevelt"));
                dataList.add(RvCategorizedQuoteModel("The future belongs to those who believe in the beauty of their dreams.", "Eleanor Roosevelt"));
                dataList.add(RvCategorizedQuoteModel("Success is not final, failure is not fatal: It is the courage to continue that counts.", "Winston Churchill"));
                dataList.add(RvCategorizedQuoteModel("Your time is limited, don't waste it living someone else's life.", "Steve Jobs"));
                dataList.add(RvCategorizedQuoteModel("The only way to do great work is to love what you do.", "Steve Jobs"));
                dataList.add(RvCategorizedQuoteModel("Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful.", "Albert Schweitzer"));
                dataList.add(RvCategorizedQuoteModel("Believe in yourself, take on your challenges, dig deep within yourself to conquer fears. Never let anyone bring you down. You got this.", "Chantal Sutherland"));
                dataList.add(RvCategorizedQuoteModel("The only limit to our realization of tomorrow will be our doubts of today.", "Franklin D. Roosevelt"));
                dataList.add(RvCategorizedQuoteModel("Don't watch the clock; do what it does. Keep going.", "Sam Levenson"));
                dataList.add(RvCategorizedQuoteModel("The only person you are destined to become is the person you decide to be.", "Ralph Waldo Emerson"));
                dataList.add(RvCategorizedQuoteModel("The harder you work for something, the greater you'll feel when you achieve it.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("The future depends on what you do today.", "Mahatma Gandhi"));
                dataList.add(RvCategorizedQuoteModel("You are never too old to set another goal or to dream a new dream.", "C.S. Lewis"));
                dataList.add(RvCategorizedQuoteModel("Success is not in what you have, but who you are.", "Bo Bennett"));
                dataList.add(RvCategorizedQuoteModel("Don't be pushed around by the fears in your mind. Be led by the dreams in your heart.", "Roy T. Bennett"));
                dataList.add(RvCategorizedQuoteModel("You have within you right now, everything you need to deal with whatever the world can throw at you.", "Brian Tracy"));
                dataList.add(RvCategorizedQuoteModel("The difference between a stumbling block and a stepping stone is how high you raise your foot.", "Benny Lewis"));
                dataList.add(RvCategorizedQuoteModel("The only way to do great work is to love what you do.", "Steve Jobs"));
                dataList.add(RvCategorizedQuoteModel("Believe you can and you're halfway there.", "Theodore Roosevelt"));
                dataList.add(RvCategorizedQuoteModel("Don't be afraid to give up the good to go for the great.", "John D. Rockefeller"));
            }
            "Inspirational" -> {
                Toast.makeText(this, "Inspirational", Toast.LENGTH_SHORT).show()
                dataList.add(RvCategorizedQuoteModel("The future belongs to those who believe in the beauty of their dreams.", "Eleanor Roosevelt"));
                dataList.add(RvCategorizedQuoteModel("Believe you can and you're halfway there.", "Theodore Roosevelt"));
                dataList.add(RvCategorizedQuoteModel("The only way to do great work is to love what you do.", "Steve Jobs"));
                dataList.add(RvCategorizedQuoteModel("Believe in yourself, take on your challenges, dig deep within yourself to conquer fears. Never let anyone bring you down. You got this.", "Chantal Sutherland"));
                dataList.add(RvCategorizedQuoteModel("You are never too old to set another goal or to dream a new dream.", "C.S. Lewis"));
                dataList.add(RvCategorizedQuoteModel("The only person you are destined to become is the person you decide to be.", "Ralph Waldo Emerson"));
                dataList.add(RvCategorizedQuoteModel("Success is not the key to happiness. Happiness is the key to success. If you love what you are doing, you will be successful.", "Albert Schweitzer"));
                dataList.add(RvCategorizedQuoteModel("The future depends on what you do today.", "Mahatma Gandhi"));
                dataList.add(RvCategorizedQuoteModel("The only limit to our realization of tomorrow will be our doubts of today.", "Franklin D. Roosevelt"));
                dataList.add(RvCategorizedQuoteModel("Don't be pushed around by the fears in your mind. Be led by the dreams in your heart.", "Roy T. Bennett"));
                dataList.add(RvCategorizedQuoteModel("The harder you work for something, the greater you'll feel when you achieve it.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("The difference between a stumbling block and a stepping stone is how high you raise your foot.", "Benny Lewis"));
                dataList.add(RvCategorizedQuoteModel("You have within you right now, everything you need to deal with whatever the world can throw at you.", "Brian Tracy"));
                dataList.add(RvCategorizedQuoteModel("Don't watch the clock; do what it does. Keep going.", "Sam Levenson"));
                dataList.add(RvCategorizedQuoteModel("Don't be afraid to give up the good to go for the great.", "John D. Rockefeller"));
                dataList.add(RvCategorizedQuoteModel("The best way to predict the future is to create it.", "Peter Drucker"));
                dataList.add(RvCategorizedQuoteModel("The only way to do great work is to love what you do.", "Steve Jobs"));
                dataList.add(RvCategorizedQuoteModel("Your time is limited, don't waste it living someone else's life.", "Steve Jobs"));
                dataList.add(RvCategorizedQuoteModel("The only way to achieve the impossible is to believe it is possible.", "Charles Kingsleigh"));
                dataList.add(RvCategorizedQuoteModel("You are capable of more than you know. Choose a goal that seems right for you and strive to be the best, however hard the path. Aim high. Behave honorably. Prepare to be alone at times, and to endure failure. Persist! The world needs all you can give.", "E.O. Wilson"));

            }
            "Happiness" -> {
                Toast.makeText(this, "Happiness", Toast.LENGTH_SHORT).show()
                dataList.add(RvCategorizedQuoteModel("Happiness is not something ready-made. It comes from your own actions.", "Dalai Lama"));
                dataList.add(RvCategorizedQuoteModel("The greatest happiness you can have is knowing that you do not necessarily require happiness.", "William Saroyan"));
                dataList.add(RvCategorizedQuoteModel("Happiness is a choice. You can choose to be happy. There's going to be stress in life, but it's your choice whether you let it affect you or not.", "Valerie Bertinelli"));
                dataList.add(RvCategorizedQuoteModel("Happiness is not in the mere possession of money; it lies in the joy of achievement, in the thrill of creative effort.", "Franklin D. Roosevelt"));
                dataList.add(RvCategorizedQuoteModel("The greatest happiness of life is the conviction that we are loved; loved for ourselves, or rather, loved in spite of ourselves.", "Victor Hugo"));
                dataList.add(RvCategorizedQuoteModel("Happiness is not a goal; it is a by-product.", "Eleanor Roosevelt"));
                dataList.add(RvCategorizedQuoteModel("Happiness is not something you postpone for the future; it is something you design for the present.", "Jim Rohn"));
                dataList.add(RvCategorizedQuoteModel("The happiness of your life depends upon the quality of your thoughts.", "Marcus Aurelius"));
                dataList.add(RvCategorizedQuoteModel("Happiness is when what you think, what you say, and what you do are in harmony.", "Mahatma Gandhi"));
                dataList.add(RvCategorizedQuoteModel("The only way to find true happiness is to risk being completely cut open.", "Chuck Palahniuk"));
                dataList.add(RvCategorizedQuoteModel("The secret of happiness is not in doing what one likes, but in liking what one does.", "James M. Barrie"));
                dataList.add(RvCategorizedQuoteModel("The true secret of happiness lies in taking a genuine interest in all the details of daily life.", "William Morris"));
                dataList.add(RvCategorizedQuoteModel("Happiness is not a state to arrive at, but a manner of traveling.", "Margaret Lee Runbeck"));
                dataList.add(RvCategorizedQuoteModel("Happiness is the art of never holding in your mind the memory of any unpleasant thing that has passed.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happiness is a warm puppy.", "Charles M. Schulz"));
                dataList.add(RvCategorizedQuoteModel("The happiness of your life depends upon the quality of your thoughts.", "Marcus Aurelius"));
                dataList.add(RvCategorizedQuoteModel("Happiness is a state of mind. It's just according to the way you look at things.", "Walt Disney"));
                dataList.add(RvCategorizedQuoteModel("Happiness is the absence of the striving for happiness.", "Zhuangzi"));
                dataList.add(RvCategorizedQuoteModel("The happiest people don't have the best of everything, they just make the best of everything.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Happiness is not having what you want. It is wanting what you have.", "Unknown"));


            }
            "Wisdom" -> {
                Toast.makeText(this, "Wisdom", Toast.LENGTH_SHORT).show()
                dataList.add(RvCategorizedQuoteModel("The only true wisdom is in knowing you know nothing.", "Socrates"));
                dataList.add(RvCategorizedQuoteModel("The only way to do great work is to love what you do.", "Steve Jobs"));
                dataList.add(RvCategorizedQuoteModel("The only thing necessary for the triumph of evil is for good men to do nothing.", "Edmund Burke"));
                dataList.add(RvCategorizedQuoteModel("The greatest enemy of knowledge is not ignorance, it is the illusion of knowledge.", "Stephen Hawking"));
                dataList.add(RvCategorizedQuoteModel("The fool doth think he is wise, but the wise man knows himself to be a fool.", "William Shakespeare"));
                dataList.add(RvCategorizedQuoteModel("Knowing yourself is the beginning of all wisdom.", "Aristotle"));
                dataList.add(RvCategorizedQuoteModel("The only source of knowledge is experience.", "Albert Einstein"));
                dataList.add(RvCategorizedQuoteModel("True knowledge exists in knowing that you know nothing.", "Socrates"));
                dataList.add(RvCategorizedQuoteModel("The more I learn, the more I realize how much I don't know.", "Albert Einstein"));
                dataList.add(RvCategorizedQuoteModel("The art of being wise is knowing what to overlook.", "William James"));
                dataList.add(RvCategorizedQuoteModel("The measure of intelligence is the ability to change.", "Albert Einstein"));
                dataList.add(RvCategorizedQuoteModel("The wise man does at once what the fool does finally.", "Niccolo Machiavelli"));
                dataList.add(RvCategorizedQuoteModel("Wisdom is not a product of schooling but of the lifelong attempt to acquire it.", "Albert Einstein"));
                dataList.add(RvCategorizedQuoteModel("Knowing others is intelligence; knowing yourself is true wisdom.", "Lao Tzu"));
                dataList.add(RvCategorizedQuoteModel("The wise understand by themselves; fools follow the reports of others.", "Tibetan Proverb"));
                dataList.add(RvCategorizedQuoteModel("A wise man can learn more from a foolish question than a fool can learn from a wise answer.", "Bruce Lee"));
                dataList.add(RvCategorizedQuoteModel("To attain knowledge, add things every day. To attain wisdom, remove things every day.", "Lao Tzu"));
                dataList.add(RvCategorizedQuoteModel("The difference between knowledge and wisdom is that knowledge is knowing what to say, and wisdom is knowing whether or not to say it.", "Unknown"));
                dataList.add(RvCategorizedQuoteModel("Knowledge comes from learning. Wisdom comes from living.", "Anthony Douglas Williams"));
                dataList.add(RvCategorizedQuoteModel("It is the mark of an educated mind to be able to entertain a thought without accepting it.", "Aristotle"));

            }
        }

        rvAdapter =  RvCategorizedQuoteAdapter(dataList, this)
        binding.rvCategorizedQuote.layoutManager = LinearLayoutManager(this)
        binding.rvCategorizedQuote.adapter = rvAdapter

        MobileAds.initialize(this) {}
        categoryQuoteBannerAdSetup()

        actionBar?.setDisplayHomeAsUpEnabled(true)

        interstitialAdSetup()
    }

    private fun categoryQuoteBannerAdSetup() {
        mAdView = findViewById(R.id.adView2)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object : AdListener() {
            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                super.onAdClicked()
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                // Code to be executed when an ad request fails.
                super.onAdFailedToLoad(adError)
                mAdView.loadAd(adRequest)
            }

            override fun onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                super.onAdLoaded();

            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                super.onAdOpened()
            }
        }
    }
    private fun interstitialAdSetup() {
        var adRequest = AdRequest.Builder().build()


        InterstitialAd.load(
            this,
            "ca-app-pub-4135026674015272/3046799037",
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {

                    mInterstitialAd = null

                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAd = interstitialAd
                }
            })

        mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
            override fun onAdClicked() {
                // Called when a click is recorded for an ad.
            }

            override fun onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                mInterstitialAd = null
            }

            override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                // Called when ad fails to show.
                mInterstitialAd = null
            }

            override fun onAdImpression() {
            }

            override fun onAdShowedFullScreenContent() {
                // Called when ad is shown.
            }
        }
    }
    override fun onBackPressed() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.show(this)
            finish()
        } else {
            finish()
        }

    }

}